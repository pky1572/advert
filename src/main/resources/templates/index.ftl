<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>雪润广告自动截图管理系统</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta content="这是我的第一个私人项目，希望客户满意！" />
        <meta content="Mosheng" name="author" />


        <!-- App favicon -->
        <link rel="shortcut icon" href="../static/assets/images/favicon.ico">

        <!-- App css -->
        <link href="../static/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="../static/css/icons.min.css" rel="stylesheet" type="text/css" />
        <link href="../static/css/app.min.css" rel="stylesheet" type="text/css" />

    </head>

    <body>

        <!-- Navigation Bar-->
        <header id="topnav">
            <nav class="navbar-custom">

                <div class="container-fluid">
                    <ul class="list-unstyled topbar-right-menu float-right mb-0">

                        <li class="dropdown notification-list">
                            <!-- Mobile menu toggle-->
                            <a class="navbar-toggle nav-link">
                                <div class="lines">
                                    <span></span>
                                    <span></span>
                                    <span></span>
                                </div>
                            </a>
                            <!-- End mobile menu toggle-->
                        </li>


                    </ul>

                    <ul class="list-inline menu-left mb-0">
                        <li class="float-left">
                            <a href="index.ftl" class="logo">
                                <span class="logo-lg">
                                    <img src="../static/assets/images/logo.png" alt="" height="18">
                                </span>
                                <span class="logo-sm">
                                    <img src="../static/assets/images/logo-sm.png" alt="" height="28">
                                </span>
                            </a>
                        </li>
                        <li class="app-search">
                            <form>
                                <input type="text" placeholder="输入关键字以搜索..." class="form-control">
                                <#--<button type="submit" class="sr-only"></button>-->
                            </form>
                        </li>
                    </ul>
                </div>

            </nav>
            <!-- end topbar-main -->

            <div class="topbar-menu">
                <div class="container-fluid">
                    <div id="navigation">
                        <!-- Navigation Menu-->
                        <ul class="navigation-menu">
                            <li class="has-submenu">
                                <a href="#">
                                    <i class="fe-airplay"></i>功能</a>
                                <ul class="submenu">
                                    <li>
                                        <a href="/screenshot">自动截图</a>
                                    </li>
                                    <li>
                                        <a href="/pictureExcle">自动导出</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="has-submenu">
                                <a href="/">
                                    <i class="fe-layers"></i></a>
                            </li>
                            <li class="has-submenu">
                                <a href="#"><i class="fe-cpu"></i>截图</a>
                                <ul class="submenu">
                                    <li>
                                        <a href="/picture/picturelist?state=1">有效截图</a>
                                    </li>
                                    <li>
                                        <a href="/picture/picturelist?state=2">无效截图</a>
                                    </li>
                                    <li>
                                        <a href="/picture/picturelist?state=0">已删除截图</a>
                                    </li>
                                    <li>
                                        <a href="/picture/toinsertpicture">添加截图</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="has-submenu">
                                <a href="/">
                                    <i class="fe-layers"></i></a>
                            </li>
                            <li class="has-submenu">
                                <a href="#"><i class="fe-bookmark"></i>规则</a>
                                <ul class="submenu">
                                    <li>
                                        <a href="/role/rolelist?state=1">已启用规则</a>
                                    </li>
                                    <li>
                                        <a href="/role/rolelist?state=2">未启用规则</a>
                                    </li>
                                    <li>
                                        <a href="/role/rolelist?state=0">被删除规则</a>
                                    </li>
                                    <li>
                                        <a href="/role/insert">添加规则</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                        <!-- End navigation menu -->

                        <div class="clearfix"></div>
                    </div>
                    <!-- end #navigation -->
                </div>
                <!-- end container -->
            </div>
            <!-- end navbar-custom -->



        </header>

        <!-- End Navigation Bar-->
        <div class="wrapper">
            <div class="container-fluid" align="center">
                <div class="account-pages mt-5 mb-5">
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-5">
                                <div class="card">
                                    <div class="card-body p-4">
                                        <div class="text-center mt-4">
                                            <h1 class="text-uppercase text-danger mt-3">雪润截图软件</h1>
                                            <p class="text-muted mt-3">首页</p>
                                        </div>
                                    </div> <!-- end card-body -->
                                </div>
                                <!-- end card -->
                            </div> <!-- end col -->
                        </div>
                        <!-- end row -->
                    </div>
                    <!-- end container -->
                </div>

            </div> <!-- end container -->
        </div>
        <!-- end wrapper -->



        <!-- Footer Start -->
        <footer class="footer">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-6">
                        Kepeng Yang &copy; 2019 - 1059193212@qq.com
                    </div>
                    <div class="col-md-6">
                        <div class="text-md-right footer-links d-none d-sm-block">
                            <a href="#">关于我们</a>
                            <a href="#">帮助</a>
                            <a href="#">联系我们</a>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
        <!-- end Footer -->


        <!-- App js -->
        <script src="../static/js/vendor.min.js"></script>
        <script src="../static/js/app.min.js"></script>

        <!-- Plugins js -->
        <script src="../static/js/vendor/Chart.bundle.js"></script>
        <script src="../static/js/vendor/jquery.sparkline.min.js"></script>
        <script src="../static/js/vendor/jquery.knob.min.js"></script>
        <script type="text/javascript">
            ! function(o) {
                "use strict";
                var r = function() {};
                r.prototype.respChart = function(r, t, e, i) {
                    var a = r.get(0).getContext("2d"),
                        l = o(r).parent();

                    function n() {
                        r.attr("width", o(l).width());
                        switch (t) {
                            case "Doughnut":
                                new Chart(a, {
                                    type: "doughnut",
                                    data: e,
                                    options: i
                                });
                                break;
                            case "Bar":
                                new Chart(a, {
                                    type: "bar",
                                    data: e,
                                    options: i
                                })
                        }
                    }
                    o(window).resize(n), n()
                }, r.prototype.init = function() {
                    this.respChart(o("#bar"), "Bar", {
                        labels: ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17",
                            "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"
                        ],
                        datasets: [{
                            label: "Sales Analytics",
                            backgroundColor: "#00acc1",
                            borderColor: "#00acc1",
                            borderWidth: 1,
                            hoverBackgroundColor: "#d4570f",
                            hoverBorderColor: "#d4570f",
                            data: [65, 59, 80, 81, 56, 89, 40, 32, 65, 59, 80, 81, 56, 89, 40, 32, 65, 59, 80, 81, 56, 89, 40, 32, 65, 59,
                                80, 81, 56, 89, 40
                            ]
                        }]
                    }, {
                        legend: {
                            display: !1
                        },
                        scales: {
                            yAxes: [{
                                gridLines: {
                                    display: !1
                                },
                                ticks: {
                                    max: 100,
                                    min: 20,
                                    stepSize: 20
                                }
                            }],
                            xAxes: [{
                                barPercentage: .3,
                                gridLines: {
                                    color: "rgba(0,0,0,0.05)"
                                }
                            }]
                        }
                    });
                    this.respChart(o("#doughnut"), "Doughnut", {
                        labels: ["Bitcoin", "Ethereum", "Cardano"],
                        datasets: [{
                            data: [80, 50, 100],
                            backgroundColor: ["#02a8b5", "#f1556c", "#e3eaef"],
                            hoverBackgroundColor: ["#02a8b5", "#f1556c", "#e3eaef"],
                            borderWidth: 3,
                            hoverBorderColor: "#fff"
                        }]
                    }, {
                        cutoutPercentage: 80,
                        legend: {
                            position: "bottom",
                            labels: {
                                padding: 30
                            }
                        }
                    })
                }, o.ChartJs = new r, o.ChartJs.Constructor = r
            }(window.jQuery),
                function(o) {
                    "use strict";
                    o.ChartJs.init()
                }(window.jQuery), $(document).ready(function() {
                var o, r = function() {
                    $("#sparkline1").sparkline([200, 2233, 233, 22333, 2323, 32332, 3232, 232, 23323], {
                        type: "line",
                        width: "100%",
                        height: "80",
                        chartRangeMax: 35,
                        lineColor: "#f1556c",
                        fillColor: "rgba(229, 43, 76, 0.3)",
                        highlightLineColor: "rgba(0,0,0,.1)",
                        highlightSpotColor: "rgba(0,0,0,.2)",
                        maxSpotColor: !1,
                        minSpotColor: !1,
                        spotColor: !1,
                        lineWidth: 1
                    }), $("#sparkline2").sparkline([0, 23, 43, 35, 44, 45, 56, 37, 40], {
                        type: "line",
                        width: "100%",
                        height: "80",
                        chartRangeMax: 50,
                        lineColor: "#00acc1",
                        fillColor: "rgba(0, 172, 193, 0.2)",
                        highlightLineColor: "rgba(0,0,0,.1)",
                        highlightSpotColor: "rgba(0,0,0,.2)",
                        maxSpotColor: !1,
                        minSpotColor: !1,
                        spotColor: !1,
                        lineWidth: 1
                    }), $("#sparkline3").sparkline([25, 23, 26, 24, 25, 32, 30, 24, 19], {
                        type: "line",
                        width: "100%",
                        height: "80",
                        chartRangeMax: 35,
                        lineColor: "#f1556c",
                        fillColor: "rgba(229, 43, 76, 0.3)",
                        highlightLineColor: "rgba(0,0,0,.1)",
                        highlightSpotColor: "rgba(0,0,0,.2)",
                        maxSpotColor: !1,
                        minSpotColor: !1,
                        spotColor: !1,
                        lineWidth: 1
                    }), $("#sparkline4").sparkline([0, 23, 43, 35, 44, 45, 56, 37, 40], {
                        type: "line",
                        width: "100%",
                        height: "80",
                        chartRangeMax: 50,
                        lineColor: "#00acc1",
                        fillColor: "rgba(0, 172, 193, 0.2)",
                        highlightLineColor: "rgba(0,0,0,.1)",
                        highlightSpotColor: "rgba(0,0,0,.2)",
                        maxSpotColor: !1,
                        minSpotColor: !1,
                        spotColor: !1,
                        lineWidth: 1
                    })
                };
                r(), $(window).resize(function(t) {
                    clearTimeout(o), o = setTimeout(function() {
                        r(), DrawMouseSpeed()
                    }, 300)
                })
            });
            ! function(e) {
                "use strict";
                var r = function() {};
                r.prototype.respChart = function(r, a, o, t) {
                    var n = r.get(0).getContext("2d"),
                        s = e(r).parent();

                    function i() {
                        r.attr("width", e(s).width());
                        switch (a) {
                            case "Line":
                                new Chart(n, {
                                    type: "line",
                                    data: o,
                                    options: t
                                });
                                break;
                            case "Doughnut":
                                new Chart(n, {
                                    type: "doughnut",
                                    data: o,
                                    options: t
                                });
                                break;
                            case "Pie":
                                new Chart(n, {
                                    type: "pie",
                                    data: o,
                                    options: t
                                });
                                break;
                            case "Bar":
                                new Chart(n, {
                                    type: "bar",
                                    data: o,
                                    options: t
                                });
                                break;
                            case "Radar":
                                new Chart(n, {
                                    type: "radar",
                                    data: o,
                                    options: t
                                });
                                break;
                            case "PolarArea":
                                new Chart(n, {
                                    data: o,
                                    type: "polarArea",
                                    options: t
                                })
                        }
                    }
                    e(window).resize(i), i()
                }, r.prototype.init = function() {
                    this.respChart(e("#lineChart"), "Line", {
                        labels: ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October"],
                        datasets: [{
                            label: "Conversion Rate",
                            fill: !1,
                            backgroundColor: "#25b343",
                            borderColor: "#25b343",
                            data: [44, 60, -33, 58, -4, 57, -89, 60, -33, 58]
                        }, {
                            label: "Average Sale Value",
                            fill: !1,
                            backgroundColor: "#e3eaef",
                            borderColor: "#e3eaef",
                            borderDash: [5, 5],
                            data: [-68, 41, 86, -49, 2, 65, -64, 86, -49, 2]
                        }]
                    }, {
                        responsive: !0,
                        tooltips: {
                            mode: "index",
                            intersect: !1
                        },
                        hover: {
                            mode: "nearest",
                            intersect: !0
                        },
                        scales: {
                            xAxes: [{
                                display: !0,
                                gridLines: {
                                    color: "rgba(0,0,0,0.1)"
                                }
                            }],
                            yAxes: [{
                                gridLines: {
                                    color: "rgba(255,255,255,0.05)",
                                    fontColor: "#fff"
                                },
                                ticks: {
                                    max: 100,
                                    min: -100,
                                    stepSize: 20
                                }
                            }]
                        }
                    });
                    this.respChart(e("#doughnut"), "Doughnut", {
                        labels: ["Bitcoin", "Ethereum", "Cardano"],
                        datasets: [{
                            data: [80, 50, 100],
                            backgroundColor: ["#02a8b5", "#fd7e14", "#e3eaef"],
                            hoverBackgroundColor: ["#02a8b5", "#fd7e14", "#e3eaef"],
                            borderWidth: 3,
                            hoverBorderColor: "#fff"
                        }]
                    }, {
                        cutoutPercentage: 80
                    });
                    this.respChart(e("#pie"), "Pie", {
                        labels: ["Desktops", "Tablets", "Mobiles"],
                        datasets: [{
                            data: [100, 121, 77],
                            backgroundColor: ["#d33319", "#675aa9", "#e3eaef"],
                            hoverBackgroundColor: ["#d33319", "#675aa9", "#e3eaef"],
                            hoverBorderColor: "#fff"
                        }]
                    });
                    this.respChart(e("#bar"), "Bar", {
                        labels: ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15"],
                        datasets: [{
                            label: "Sales Analytics",
                            backgroundColor: "#4b88e4",
                            borderColor: "#4b88e4",
                            borderWidth: 1,
                            hoverBackgroundColor: "#675aa9",
                            hoverBorderColor: "#675aa9",
                            data: [65, 59, 80, 81, 56, 89, 40, 32, 65, 59, 80, 81, 56, 89, 40, 32, 65, 59, 80, 81, 56, 89, 40, 32, 65, 59,
                                80, 81, 56, 89, 40
                            ]
                        }]
                    }, {
                        legend: {
                            display: !1
                        },
                        scales: {
                            yAxes: [{
                                gridLines: {
                                    display: !1
                                },
                                ticks: {
                                    max: 100,
                                    min: 20,
                                    stepSize: 20
                                }
                            }],
                            xAxes: [{
                                barPercentage: .3,
                                gridLines: {
                                    color: "rgba(0,0,0,0.05)"
                                }
                            }]
                        }
                    });
                    this.respChart(e("#radar"), "Radar", {
                        labels: ["Eating", "Drinking", "Sleeping", "Designing", "Coding", "Cycling", "Running"],
                        datasets: [{
                            label: "Desktops",
                            backgroundColor: "rgba(179,181,198,0.2)",
                            borderColor: "rgba(179,181,198,1)",
                            pointBackgroundColor: "rgba(179,181,198,1)",
                            pointBorderColor: "#fff",
                            pointHoverBackgroundColor: "#fff",
                            pointHoverBorderColor: "rgba(179,181,198,1)",
                            data: [65, 59, 90, 81, 56, 55, 40]
                        }, {
                            label: "Tablets",
                            backgroundColor: "rgba(255,99,132,0.2)",
                            borderColor: "rgba(255,99,132,1)",
                            pointBackgroundColor: "rgba(255,99,132,1)",
                            pointBorderColor: "#fff",
                            pointHoverBackgroundColor: "#fff",
                            pointHoverBorderColor: "rgba(255,99,132,1)",
                            data: [28, 48, 40, 19, 96, 27, 100]
                        }]
                    });
                    this.respChart(e("#polarArea"), "PolarArea", {
                        datasets: [{
                            data: [11, 16, 7, 18],
                            backgroundColor: ["#297ef6", "#45bbe0", "#ebeff2", "#1ea69a"],
                            label: "My dataset",
                            hoverBorderColor: "#fff"
                        }],
                        labels: ["Series 1", "Series 2", "Series 3", "Series 4"]
                    })
                }, e.ChartJs = new r, e.ChartJs.Constructor = r
            }(window.jQuery),
                function(e) {
                    "use strict";
                    e.ChartJs.init()
                }(window.jQuery);
        </script>
    </body>
</html>
