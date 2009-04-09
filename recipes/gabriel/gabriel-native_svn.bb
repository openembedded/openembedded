require gabriel_svn.bb
inherit native
DEPENDS = "libssh-native glib-2.0-native dbus-native dbus-glib-native"

do_deploy() {
	install -d ${DEPLOY_DIR_TOOLS}
	install -m 0755 src/gabriel ${DEPLOY_DIR_TOOLS}/gabriel-${PV}
	rm -f ${DEPLOY_DIR_TOOLS}/gabriel
	ln -sf ./gabriel-${PV} ${DEPLOY_DIR_TOOLS}/gabriel
}
                                

addtask deploy before do_package after do_install
