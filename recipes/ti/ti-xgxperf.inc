HOMEPAGE = "http://processors.wiki.ti.com/index.php/Xgxperf"
DESCRIPTION = "Qt Benchmarking Utility With Sample GUI applications For 2D/3D UseCases"

SRCREV = "79"
SRC_URI = "svn://gforge.ti.com/svn/gleslayer/;module=trunk;proto=https;user=anonymous;pswd=''"

S = "${WORKDIR}/trunk/Packages/OMAP3_Graphics_SDK/xgxperf/xgxperf"

do_install() {
    install -d ${D}${bindir}
    install -d ${D}${libdir}
    install -d ${D}${datadir}/xgxperf

    install -m 0644 ${S}/automationlib/libautomation.so.1.0.0 ${D}${libdir}
    install -m 0644 ${S}/autoscreenlib/libautoscreen.so.1.0.0 ${D}${libdir}
    install -m 0644 ${S}/ecgmonitorlib/libecgmonitor.so.1.0.0 ${D}${libdir}
    install -m 0644 ${S}/vslib/libvslib.so.1.0.0 ${D}${libdir}
    install -m 0644 ${S}/widgetlib/libwidget.so.1.0.0 ${D}${libdir}

    install -m 0755 ${S}/applicationmanager/xgxperf_app/xgxperf_app ${D}${bindir}
    install -m 0755 ${S}/applicationmanager/xgxperf_launcher/xgxperf_launcher ${D}${bindir}

    install -m 0755 ${S}/xgxperfserver/xgxperfserver ${D}${bindir}

    install -m 0755 ${WORKDIR}/trunk/Packages/OMAP3_Graphics_SDK/xgxperf/server/* ${D}${datadir}/xgxperf/

    ln -sf ${libdir}/libautomation.so.1.0.0 ${D}${libdir}/libautomation.so
    ln -sf ${libdir}/libautoscreen.so.1.0.0 ${D}${libdir}/libautoscreen.so
    ln -sf ${libdir}/libecgmonitor.so.1.0.0 ${D}${libdir}/libecgmonitor.so
    ln -sf ${libdir}/libwidget.so.1.0.0 ${D}${libdir}/libwidget.so
    ln -sf ${libdir}/libvslib.so.1.0.0 ${D}${libdir}/libvslib.so
}
