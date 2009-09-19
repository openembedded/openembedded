DESCRIPTION = "Python bindings for libnotify" 
SECTION = "devel/python" 
PRIORITY = "optional" 
LICENSE = "LGPLv2" 
HOMEPAGE = "http://www.galago-project.org/" 
SRCNAME = "notify-python" 
DEPENDS = "python-native libnotify" 
 
SRC_URI = "http://www.galago-project.org/files/releases/source/${SRCNAME}/${SRCNAME}-${PV}.tar.gz" 
S = "${WORKDIR}/${SRCNAME}-${PV}" 
 
inherit distutils-base autotools pkgconfig

do_configure_prepend() {
		sed -i "s/py_prefix=.*$/py_prefix=\"${@"${STAGING_DIR_TARGET}".replace("/","\/")}\/usr\"/" ${S}/acinclude.m4
		sed -i "s/py_exec_prefix=.*$/py_exec_prefix=\"${@"${STAGING_DIR_TARGET}".replace("/","\/")}\/usr\"/" ${S}/acinclude.m4
}

FILES_${PN} += "${datadir}"
