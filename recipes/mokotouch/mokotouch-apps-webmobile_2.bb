require mokotouch.inc

DEPENDS = "mokotouch-coreservices-mokotouch"

do_configure(){
cd ${S}/MokoTouch/Apps/WebMobile
rm UIKit.framework
ln -s "${S}/MokoTouch/Frameworks/UIKit/" UIKit.framework
${OE_QMAKE_QMAKE} WebMobile.pro
}

do_compile(){
cd ${S}/MokoTouch/Apps/WebMobile
oe_runmake
}

do_install(){
install -d "${D}/${libdir}"
install "${S}/MokoTouch/Apps/WebMobile/BUILD/App/libWebMobile.so.1.0.0" "${D}/${libdir}/libWebMobile.so.1.0.0"
install "${S}/MokoTouch/Apps/WebMobile/BUILD/App/libWebMobile.so.1.0.0" "${D}/${libdir}/libWebMobile.so.1.0"
install "${S}/MokoTouch/Apps/WebMobile/BUILD/App/libWebMobile.so.1.0.0" "${D}/${libdir}/libWebMobile.so.1"
install "${S}/MokoTouch/Apps/WebMobile/BUILD/App/libWebMobile.so.1.0.0" "${D}/${libdir}/libWebMobile.so"
}

