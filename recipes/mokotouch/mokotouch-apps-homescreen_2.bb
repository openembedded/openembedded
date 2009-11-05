require mokotouch.inc

DEPENDS = "mokotouch-coreservices-mokotouch"

do_configure(){
cd ${S}/MokoTouch/Apps/Homescreen
rm UIKit.framework
ln -s "${S}/MokoTouch/Frameworks/UIKit/" UIKit.framework
${OE_QMAKE_QMAKE} Homescreen.pro
}

do_compile(){
cd ${S}/MokoTouch/Apps/Homescreen
oe_runmake
}

do_install(){
install -d "${D}/${libdir}"
install "${S}/MokoTouch/Apps/Homescreen/BUILD/App/libHomescreen.so.1.0.0" "${D}/${libdir}/libHomescreen.so.1.0.0"
install "${S}/MokoTouch/Apps/Homescreen/BUILD/App/libHomescreen.so.1.0.0" "${D}/${libdir}/libHomescreen.so.1.0"
install "${S}/MokoTouch/Apps/Homescreen/BUILD/App/libHomescreen.so.1.0.0" "${D}/${libdir}/libHomescreen.so.1"
install "${S}/MokoTouch/Apps/Homescreen/BUILD/App/libHomescreen.so.1.0.0" "${D}/${libdir}/libHomescreen.so"
}
