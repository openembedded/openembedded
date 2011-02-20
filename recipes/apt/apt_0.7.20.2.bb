DEPENDS = "curl db"
RDEPENDS_${PN} = "dpkg"

require apt.inc

SRC_URI += "file://no-doxygen.patch \
            file://no-ko-translation.patch \
            file://fix-gcc-4.4-compile.patch \
            file://use-host.patch "
PR = "r4"

require apt-package.inc

FILES_${PN} += "${bindir}/apt-key"

fix_eabi_architecture() {
	sed -i \
	's:^#define COMMON_ARCH "arm"$:#define COMMON_ARCH "armel":' \
		${S}/include/config.h
}

do_configure_append_linux-gnueabi() {
	fix_eabi_architecture
}

do_configure_append_linux-uclibceabi() {
	fix_eabi_architecture
}

SRC_URI[md5sum] = "e6ee1b594f6ed5fab5cb593ee46cfc21"
SRC_URI[sha256sum] = "4dc935a520c65705795ada5942b658f6e86b22eefc7032342267272bd6566b05"
