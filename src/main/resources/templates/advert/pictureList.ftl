<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>高级表格 - 默笙后台管理系统</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta content="这不仅仅是一个后台管理系统，它基于BT4，超强的自适应，简洁，高效，大方" />
        <meta content="Mosheng" name="author" />


        <!-- App favicon -->
        <link rel="shortcut icon" href="../../static/assets/images/favicon.ico">

        <!-- third party css -->
        <link href="../../static/css/vendor/dataTables.bootstrap4.css" rel="stylesheet" type="text/css" />
        <link href="../../static/css/vendor/responsive.bootstrap4.css" rel="stylesheet" type="text/css" />
        <link href="../../static/css/vendor/buttons.bootstrap4.css" rel="stylesheet" type="text/css" />
        <link href="../../static/css/vendor/select.bootstrap4.css" rel="stylesheet" type="text/css" />
        <!-- third party css end -->

        <!-- App css -->
        <link href="../../static/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="../../static/css/icons.min.css" rel="stylesheet" type="text/css" />
        <link href="../../static/css/app.min.css" rel="stylesheet" type="text/css" />

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
                            <a href="../index.ftl" class="logo">
                                <span class="logo-lg">
                                    <img src="../../static/assets/images/logo.png" alt="" height="18">
                                </span>
                                <span class="logo-sm">
                                    <img src="../../static/assets/images/logo-sm.png" alt="" height="28">
                                </span>
                            </a>
                        </li>
                        <li class="app-search">
                            <form>
                                <input type="text" placeholder="输入关键字以搜索..." class="form-control">

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
            <div class="container-fluid">

                <!-- start page title -->
                <div class="row">
                    <div class="col-12">
                        <div class="page-title-box">
                            <div class="page-title-right">
                                <ol class="breadcrumb m-0">
                                    <li class="breadcrumb-item"><a href="/">主页</a></li>
                                    <li class="breadcrumb-item">${zhuangtai}截图数据</li>
                                </ol>
                            </div>
                            <h4 class="page-title">${zhuangtai}截图</h4>
                        </div>
                    </div>
                </div>     
                <!-- end page title -->


                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <table id="basic-datatable" class="table dt-responsive nowrap">
                                    <thead>
                                        <tr>
                                            <th>id</th>
                                            <th>主站</th>
                                            <th>版位</th>
                                            <th>车型</th>
                                            <th>文章标题</th>
                                            <#--<th>截图地址</th>-->
                                            <th>截图时间</th>
                                            <th>编辑</th>
                                        </tr>
                                    </thead>


                                    <tbody>
                                    <#list pictureList as picture>
                                    <tr>
                                        <td>${picture.getPictreid()?c}</td>
                                        <td><a href="${picture.getWebsiteurl()}">${picture.getWebsitename()}</a></td>
                                        <td>${picture.getLevel()}</td>
                                        <td>${picture.getModelname()}</td>
                                        <td><a href="${picture.getArticleurl()}">${picture.getTitle()}</a></td>
                                        <#--<td>${picture.getPictreurl()}</td>-->
                                        <td>${picture.getCreatetime()?string('yyyy-MM-dd HH:mm:ss')}</td>
                                        <td>
                                            <a href="/picture/pictureedit?pictreid=${picture.getPictreid()?c}">编辑</a>
                                        </td>
                                    </tr>
                                    </#list>
                                    </tbody>
                                </table>

                            </div> <!-- end card body-->
                        </div> <!-- end card -->
                    </div><!-- end col-->
                </div>
                <!-- end row-->
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
        <script src="../../static/js/vendor.min.js"></script>
        <script src="../../static/js/app.min.js"></script>

        <!-- third party js -->
        <script src="../../static/js/vendor/jquery.dataTables.js"></script>
        <script src="../../static/js/vendor/dataTables.bootstrap4.js"></script>
        <script src="../../static/js/vendor/dataTables.responsive.min.js"></script>
        <script src="../../static/js/vendor/responsive.bootstrap4.min.js"></script>
        <script src="../../static/js/vendor/dataTables.buttons.min.js"></script>
        <script src="../../static/js/vendor/buttons.bootstrap4.min.js"></script>
        <script src="../../static/js/vendor/buttons.html5.min.js"></script>
        <script src="../../static/js/vendor/buttons.flash.min.js"></script>
        <script src="../../static/js/vendor/buttons.print.min.js"></script>
        <script src="../../static/js/vendor/dataTables.keyTable.min.js"></script>
        <script src="../../static/js/vendor/dataTables.select.min.js"></script>
        <!-- third party js ends -->

        <!-- demo app -->
        <script src="../../static/js/pages/datatables.init.js"></script>
        <!-- end demo js-->

    </body>
</html>
