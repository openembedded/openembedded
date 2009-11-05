require mokotouch.inc

do_configure(){
cd ${S}/MokoTouch/Frameworks/UIKit/
${OE_QMAKE_QMAKE} UIKit.pro
}

do_compile(){
cd ${S}/MokoTouch/Frameworks/UIKit/
oe_runmake
}

do_install(){
install -d "${D}/${libdir}"
install "${S}/MokoTouch/Frameworks/UIKit/BUILD/libs/libUIKit.so.1.0.0" "${D}/${libdir}/libUIKit.so.1.0.0"
install "${S}/MokoTouch/Frameworks/UIKit/BUILD/libs/libUIKit.so.1.0.0" "${D}/${libdir}/libUIKit.so.1.0"
install "${S}/MokoTouch/Frameworks/UIKit/BUILD/libs/libUIKit.so.1.0.0" "${D}/${libdir}/libUIKit.so.1"
install "${S}/MokoTouch/Frameworks/UIKit/BUILD/libs/libUIKit.so.1.0.0" "${D}/${libdir}/libUIKit.so"
}

do_stage() {
install "${S}/MokoTouch/Frameworks/UIKit/BUILD/libs/libUIKit.so.1.0.0" "${STAGING_LIBDIR}/libUIKit.so.1.0.0"
install "${S}/MokoTouch/Frameworks/UIKit/BUILD/libs/libUIKit.so.1.0.0" "${STAGING_LIBDIR}/libUIKit.so.1.0"
install "${S}/MokoTouch/Frameworks/UIKit/BUILD/libs/libUIKit.so.1.0.0" "${STAGING_LIBDIR}/libUIKit.so.1"
install "${S}/MokoTouch/Frameworks/UIKit/BUILD/libs/libUIKit.so.1.0.0" "${STAGING_LIBDIR}/libUIKit.so"
}
