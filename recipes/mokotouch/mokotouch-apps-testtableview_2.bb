require mokotouch.inc

DEPENDS = "mokotouch-coreservices-mokotouch"

do_configure(){
cd ${S}/MokoTouch/Apps/TestTableView
rm UIKit.framework
ln -s "${S}/MokoTouch/Frameworks/UIKit/" UIKit.framework
${OE_QMAKE_QMAKE} TestTableView.pro
}

do_compile(){
cd ${S}/MokoTouch/Apps/TestTableView
oe_runmake
}

do_install(){
install -d "${D}/${libdir}"
install "${S}/MokoTouch/Apps/TestTableView/BUILD/App/libTestTableView.so.1.0.0" "${D}/${libdir}/libTestTableView.so.1.0.0"
install "${S}/MokoTouch/Apps/TestTableView/BUILD/App/libTestTableView.so.1.0.0" "${D}/${libdir}/libTestTableView.so.1.0"
install "${S}/MokoTouch/Apps/TestTableView/BUILD/App/libTestTableView.so.1.0.0" "${D}/${libdir}/libTestTableView.so.1"
install "${S}/MokoTouch/Apps/TestTableView/BUILD/App/libTestTableView.so.1.0.0" "${D}/${libdir}/libTestTableView.so"
}

