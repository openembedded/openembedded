require mokotouch.inc

DEPENDS = "mokotouch-coreservices-mokotouch"

do_configure(){
cd ${S}/MokoTouch/Apps/CustomTableView
rm UIKit.framework
ln -s "${S}/MokoTouch/Frameworks/UIKit/" UIKit.framework
${OE_QMAKE_QMAKE} CustomTableView.pro
}

do_compile(){
cd ${S}/MokoTouch/Apps/CustomTableView
oe_runmake
}

do_install(){
install -d "${D}/${libdir}"
install "${S}/MokoTouch/Apps/CustomTableView/BUILD/App/libCustomTableView.so.1.0.0" "${D}/${libdir}/libCustomTableView.so.1.0.0"
install "${S}/MokoTouch/Apps/CustomTableView/BUILD/App/libCustomTableView.so.1.0.0" "${D}/${libdir}/libCustomTableView.so.1.0"
install "${S}/MokoTouch/Apps/CustomTableView/BUILD/App/libCustomTableView.so.1.0.0" "${D}/${libdir}/libCustomTableView.so.1"
install "${S}/MokoTouch/Apps/CustomTableView/BUILD/App/libCustomTableView.so.1.0.0" "${D}/${libdir}/libCustomTableView.so"
}

