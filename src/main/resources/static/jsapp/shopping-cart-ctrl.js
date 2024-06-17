app.controller("cart-ctrl", function ($scope, $http, $rootScope) {
    $scope.dimensionDetails = {};
    $scope.colorDetails = {};
    $scope.products = {};
    $scope.form = {};
    $scope.form.quantity = 1;
    $scope.form1 = {
        product: {},
        color: {},
        dimension: {},
        price: 0,
        quantity: 0,
        status: 0
    };
    $scope.formOder = {};
    // quản lý giỏ hàng
    var $cart = $scope.cart = {
        items: [],
        add(id) { // thêm sản phẩm vào giỏ hàng
            var item = this.items.find(item => item.product.id == id);
            if ($scope.form.dimension && $scope.form.color && $scope.form.quantity > 0) {
                var item1 = this.items.find(item1 => item1.dimension.id == $scope.form.dimension);
                var item2 = this.items.find(item2 => item2.color.id == $scope.form.color);
                if (item && item1 && item2) {
                    var index = this.items.findIndex(item => item.id == id);
                    item.quantity += $scope.form.quantity;
                    this.items[index] = item;
                    this.saveToLocalStorage();
                } else {
                    $http.get(`/rest/color/` + $scope.form.color).then(resp => {
                        $scope.form1.color = resp.data;
                        $http.get(`/rest/dimensiondetail/${id}/` + $scope.form.dimension).then(resp => {
                            $scope.dimensionDetails = resp.data;
                            $scope.form1.dimension = $scope.dimensionDetails.dimension;
                            $scope.form1.price = $scope.dimensionDetails.price;
                            $http.get(`/rest/products/${id}`).then(resp => {
                                // chưa có sản phẩm thì tải trên server về
                                $scope.products = resp.data;
                                $scope.form1.product = $scope.products;
                                $scope.form1.quantity = $scope.form.quantity;
                                $scope.form1.status = 1;
                                console.log($scope.form1)
                                this.items.push($scope.form1);
                                this.saveToLocalStorage();
                            })
                        })
                    })
                }
            } else if ($scope.form.dimension && $scope.form.color) {
                var item1 = this.items.find(item1 => item1.dimension.id == $scope.form.dimension);
                var item2 = this.items.find(item2 => item2.color.id == $scope.form.color);
                if (item && item1 && item2) {
                    var index = this.items.findIndex(item => item.id == id);
                    item.quantity++;
                    this.items[index] = item;
                    this.saveToLocalStorage();
                } else {
                    $http.get(`/rest/color/` + $scope.form.color).then(resp => {
                        $scope.form1.color = resp.data;
                        $http.get(`/rest/dimensiondetail/${id}/` + $scope.form.dimension).then(resp => {
                            $scope.dimensionDetails = resp.data;
                            $scope.form1.dimension = $scope.dimensionDetails.dimension;
                            $scope.form1.price = $scope.dimensionDetails.price;
                            $http.get(`/rest/products/${id}`).then(resp => {
                                // chưa có sản phẩm thì tải trên server về
                                $scope.products = resp.data;
                                $scope.form1.product = $scope.products;
                                $scope.form1.quantity = 1;
                                $scope.form1.status = 1;
                                console.log($scope.form1)
                                this.items.push($scope.form1);
                                this.saveToLocalStorage();
                            })
                        })
                    })
                }
            } else {
                if ($scope.form.color && $scope.form.quantity > 0) {
                    $http.get(`/rest/dimensiondetail/${id}/`).then(resp => {
                        $scope.dimensionDetails = resp.data;
                        $scope.form1.dimension = $scope.dimensionDetails[0].dimension;
                        $scope.form1.price = $scope.dimensionDetails[0].price;
                        var item1 = this.items.find(item1 => item1.dimension.id == $scope.form1.dimension.id);
                        var item2 = this.items.find(item2 => item2.color.id == $scope.form.color);
                        if (item && item1 && item2) {
                            var index = this.items.findIndex(item => item.id == id);
                            item.quantity += $scope.form.quantity;
                            this.items[index] = item;
                            this.saveToLocalStorage();
                        } else {
                            $http.get(`/rest/color/` + $scope.form.color).then(resp => {
                                $scope.form1.color = resp.data;
                                $http.get(`/rest/products/${id}`).then(resp => {
                                    // chưa có sản phẩm thì tải trên server về
                                    $scope.products = resp.data;
                                    $scope.form1.product = $scope.products;
                                    $scope.form1.quantity = $scope.form.quantity;
                                    $scope.form1.status = 1;
                                    console.log($scope.form1)
                                    this.items.push($scope.form1);
                                    this.saveToLocalStorage();
                                })
                            })
                        }
                    })

                } else if ($scope.form.dimension && $scope.form.quantity > 0) {
                    $http.get(`/rest/colorDetail/${id}`).then(resp => {
                        $scope.colorDetails = resp.data;
                        console.log($scope.colorDetails);
                        $scope.form1.color = $scope.colorDetails[0].color;
                        var item1 = this.items.find(item1 => item1.dimension.id == $scope.form.dimension);
                        var item2 = this.items.find(item2 => item2.color.id == $scope.form1.color.id);
                        if (item && item1 && item2) {
                            var index = this.items.findIndex(item => item.id == id);
                            item.quantity += $scope.form.quantity;
                            this.items[index] = item;
                            this.saveToLocalStorage();
                        } else {
                            $http.get(`/rest/dimensiondetail/${id}/` + $scope.form.dimension).then(resp => {
                                $scope.dimensionDetails = resp.data;
                                $scope.form1.dimension = $scope.dimensionDetails.dimension;
                                $scope.form1.price = $scope.dimensionDetails.price;
                                $http.get(`/rest/products/${id}`).then(resp => {
                                    // chưa có sản phẩm thì tải trên server về
                                    $scope.products = resp.data;
                                    $scope.form1.product = $scope.products;
                                    $scope.form1.quantity = $scope.form.quantity;
                                    $scope.form1.status = 1;
                                    console.log($scope.form1)
                                    this.items.push($scope.form1);
                                    this.saveToLocalStorage();
                                })
                            })
                        }
                    })

                }
                else {
                    $http.get(`/rest/colorDetail/${id}`).then(resp => {
                        $scope.colorDetails = resp.data;
                        console.log($scope.colorDetails);
                        $scope.form1.color = $scope.colorDetails[0].color;
                        $http.get(`/rest/dimensiondetails/${id}`).then(resp => {
                            $scope.dimensionDetails = resp.data;
                            $scope.form1.dimension = $scope.dimensionDetails[0].dimension;
                            $scope.form1.price = $scope.dimensionDetails[0].price;
                            var item1 = this.items.find(item1 => item1.dimension.id == $scope.form1.dimension.id);
                            var item2 = this.items.find(item2 => item2.color.id == $scope.form1.color.id);
                            if (item && item1 && item2) {
                                var index = this.items.findIndex(item => item.id == id);
                                item.quantity += $scope.form.quantity;
                                this.items[index] = item;
                                this.saveToLocalStorage();
                            } else {
                                $http.get(`/rest/products/${id}`).then(resp => {
                                    // chưa có sản phẩm thì tải trên server về
                                    $scope.products = resp.data;
                                    $scope.form1.product = $scope.products;
                                    $scope.form1.quantity = 1;
                                    $scope.form1.status = 1;
                                    console.log($scope.form1);
                                    this.items.push($scope.form1);
                                    this.saveToLocalStorage();
                                })
                            }
                        })
                    })

                }
            }
            alert("Thêm Sản Phẩm Vào Giỏ Thành Công!")
        },
        remove(id) { // xóa sản phẩm khỏi giỏ hàng
            var index = this.items.findIndex(item => item.id == id);
            this.items.splice(index, 1);
            // splice: xóa 1 phần tử khỏi mảng
            this.saveToLocalStorage();
        },
        removeIndex(index) { // xóa sản phẩm khỏi giỏ hàng
            //            var index = this.items.findIndex(item => item.id == id);
            this.items.splice(index, 1);
            // splice: xóa 1 phần tử khỏi mảng
            this.saveToLocalStorage();
        },
        clear() { // Xóa sạch các mặt hàng trong giỏ
            this.items = []
            this.saveToLocalStorage();
        },
        amt_of(item) { // tính thành tiền của 1 sản phẩm
            return item.price * item.quantity;
        },
        get count() { // tính tổng số lượng các mặt hàng trong giỏ
            return this.items
                .map(item => item.quantity)
                .reduce((total, quantity) => total += quantity, 0);
        },
        get amount() { // tổng thành tiền các mặt hàng trong giỏ
            return this.items
                .map(item => this.amt_of(item))
                .reduce((total, amt) => total += amt, 0);
        },
        saveToLocalStorage() { // lưu giỏ hàng vào local storage
            console.log(this.items);
            var json = JSON.stringify(angular.copy(this.items));
            localStorage.setItem("cart", json);
            console.log(json);
        },
        loadFromLocalStorage() { // đọc giỏ hàng từ local storage
            var json = localStorage.getItem("cart");
            console.log(json);
            this.items = json ? JSON.parse(json) : [];
            console.log(this.items);
        }
    }
    $cart.loadFromLocalStorage();

    // Đặt hàng
    $scope.order = {
        purchase() {
            $scope.formOder.id ="",
            $scope.formOder.createDate = new Date();
            var item = angular.copy($scope.formOder);
            console.log($scope.formOder);
            console.log($cart.items);
            // Thực hiện đặt hàng
            $http.post("/rest/cart", {
            order: item,
            orderDetailList: $cart.items
            }).then(resp => {
                alert("Đặt hàng thành công!");
                $cart.clear();
//                location.href = "/order/detail/" + resp.data.id;
            }).catch(error => {
                alert("Đặt hàng lỗi!")
                console.log(error)
            })
        }
    }
})