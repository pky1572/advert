<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title> 基本表格-默笙后台管理系统</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta content="这不仅仅是一个后台管理系统，它基于BT4，超强的自适应，简洁，高效，大方" />
        <meta content="Mosheng" name="author" />


        <!-- App favicon -->
        <link rel="shortcut icon" href="../../static/assets/images/favicon.ico">

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

        <div class="wrapper">
            <div class="container-fluid">

                <!-- start page title -->
                <div class="row">
                    <div class="col-12">
                        <div class="page-title-box">
                            <div class="page-title-right">
                                <ol class="breadcrumb m-0">
                                    <li class="breadcrumb-item"><a href="/">主页</a></li>
                                    <li class="breadcrumb-item">添加规则</li>
                                </ol>
                            </div>
                            <h4 class="page-title">规则详细数据</h4>
                        </div>
                    </div>
                </div>
                <!-- end page title -->

                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <form action="/role/insertrole"  method="post" enctype="multipart/form-data">
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">规则（标题）</label>
                                        <div class="col-sm-10">
                                        <input type="text" class="form-control" name="roletitle" placeholder="请输入文章的标题">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">文章地址</label>
                                        <div class="col-sm-10">
                                        <input type="text" class="form-control" name="websiteurl" placeholder="请输入文章的网址">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">文章网站</label>
                                        <div class="col-sm-10">
                                        <select name="websiteid" class="form-control">
                                                <#list websiteList as website>
                                                    <option value="${website.getWebsiteid()?c}">${website.getWebsitename()}</option>
                                                </#list>
                                        </select>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">车型</label>
                                        <div class="col-sm-10">
                                        <select name="modelid" class="form-control">
                                                <#list modelList as model>
                                                    <#if model.getModelname()!="未归类">
                                                        <option value="${model.getModelid()?c}">${model.getModelname()}</option>
                                                    </#if>
                                                </#list>
                                        </select>
                                        </div>
                                    </div>
                                    <div class="form-group row" >
                                        <button type="submit" class="btn btn-primary">提交</button>
                                    </div>
                                </form>

                            </div> <!-- end card-body-->
                        </div> <!-- end card-->
                    </div>
                    <!-- end col -->

                    <div class="col-lg-6">
                        <div class="card">
                            <div class="card-body">

                            </div>  <!-- end card-body -->
                        </div>  <!-- end card -->
                    </div>  <!-- end col -->

                </div>
                <!-- end row -->
            </div> <!-- end container -->
        </div>
        <!-- end wrapper -->


        <!-- Footer Start -->
        <footer class="footer">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-6">
                        Mosheng Admin &copy; 2018 - tecms.net
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

    </body>
</html>
