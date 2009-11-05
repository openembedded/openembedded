require mokotouch.inc

DEPENDS = "mokotouch-coreservices-mokotouch"

do_configure(){
cd ${S}/MokoTouch/Apps/TestKeyboard
rm UIKit.framework
ln -s "${S}/MokoTouch/Frameworks/UIKit/" UIKit.framework
${OE_QMAKE_QMAKE} TestKeyboard.pro
}

do_compile(){
cd ${S}/MokoTouch/Apps/TestKeyboard
oe_runmake
}

do_install(){
install -d "${D}/${libdir}"
install "${S}/MokoTouch/Apps/TestKeyboard/BUILD/App/libTestKeyboard.so.1.0.0" "${D}/${libdir}/libTestKeyboard.so.1.0.0"
install "${S}/MokoTouch/Apps/TestKeyboard/BUILD/App/libTestKeyboard.so.1.0.0" "${D}/${libdir}/libTestKeyboard.so.1.0"
install "${S}/MokoTouch/Apps/TestKeyboard/BUILD/App/libTestKeyboard.so.1.0.0" "${D}/${libdir}/libTestKeyboard.so.1"
install "${S}/MokoTouch/Apps/TestKeyboard/BUILD/App/libTestKeyboard.so.1.0.0" "${D}/${libdir}/libTestKeyboard.so"
}

