require kismet.inc

# patches *.diff are from openSUSE
# FIXME:
#SRC_URI += "file://fix_strip.patch"
SRC_URI += "file://hardcoded-usr.patch"

do_configure_prepend() {
	# OE still has only ncurses5 with config script called ncurses-config.
	# mangle ncursesw5-config check to nonsense to prevent access to the host ncursesw5-config
	sed -i 's/ncurses5-config/ncurses-config/g;s/ncursesw5-config/ncursesw-not-avaliable-in-oe-config/g' configure.in
}
# FIXME:
fakeroot do_install() {
     oe_runmake "DESTDIR=${D}" install
}
CONFFILES_${PN} = "${sysconfdir}/kismet.conf ${sysconfdir}/kismet_drone.conf"

PR = "r0"

SRC_URI[md5sum] = "85e59186eb529889118b5635f35cf57d"
SRC_URI[sha256sum] = "b1bae7a97e7a904bf620f285aa0d62ebc1fd3b54b671fbca125405036f949e80"
