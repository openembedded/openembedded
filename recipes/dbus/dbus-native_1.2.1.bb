require dbus.inc
PR = "${INC_PR}.3"
RRECOMMENDS_${PN} = ""
RDEPENDS_${PN} = ""
inherit native

EXTRA_OECONF_X = "--without-x"

DEPENDS = "glib-2.0-native libxml2-native expat-native"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/dbus-${PV}"

SRC_URI = "\
  http://dbus.freedesktop.org/releases/dbus/dbus-${PV}.tar.gz \
  file://cross.patch \
  file://tmpdir.patch \
  file://fix-install-daemon.patch \
  file://dbus-1.init \
"

do_install_append() {
	# for dbus-glib-native introspection generation
	install -d ${D}${datadir}/dbus
	install -m 0644 bus/session.conf ${D}${datadir}/dbus/session.conf
}

NATIVE_INSTALL_WORKS = "1"

SRC_URI[md5sum] = "b57aa1ba0834cbbb1e7502dc2cbfacc2"
SRC_URI[sha256sum] = "8016540602189e1dca6aca6b7c0735706387e4f85ced75217c6a874980fd0e86"
