require mokotouch.inc

DEPENDS = "mokotouch-frameworks-uikit"

do_configure(){
cd ${S}/MokoTouch/CoreServices/MokoTouch
rm UIKit.framework
ln -s "${S}/MokoTouch/Frameworks/UIKit/" UIKit.framework
${OE_QMAKE_QMAKE} MokoTouch.pro
}

do_compile(){
cd ${S}/MokoTouch/CoreServices/MokoTouch
oe_runmake
}

do_install(){
install -d ${D}/${sysconfdir}
install -d ${D}/${bindir}

install qte.env ${D}/${sysconfdir}/mokotouch.env
install "${S}/MokoTouch/CoreServices/MokoTouch/BUILD/Service/MokoTouch" "${D}/${bindir}/MokoTouch"
}

FILES_${PN} = "${bindir}/MokoTouch ${sysconfdir}/mokotouch.env"
