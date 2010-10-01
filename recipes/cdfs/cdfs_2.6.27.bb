DESCRIPTION = "CDfs filesystem"
HOMEPAGE = "http://users.elis.ugent.be/~mronsse/cdfs/"
SECTION = "kernel/modules"
LICENSE = "GPL"

SRC_URI = " \
        http://users.elis.ugent.be/~mronsse/cdfs/download/${P}.tar.bz2 \
        file://0001-Fix-compile-error-with-linux-2.6.32.patch \
"
SRC_URI[md5sum] = "ac64c014a90e3c488394832ea29605b3"
SRC_URI[sha256sum] = "d034f6c6d9578fe2addfaeceaa101584a4a1fc9f27d825c340baebd345d8d724"

inherit module

do_install() {
        unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
        oe_runmake -C "${STAGING_KERNEL_DIR}" DEPMOD=echo INSTALL_MOD_PATH="${D}" SUBDIRS="${S}" ${MODULE_MAKE_FLAGS} modules_install
}

PACKAGES = "${PN}"
