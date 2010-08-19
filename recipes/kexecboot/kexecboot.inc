LICENSE = "GPL"

DEPENDS = "klibc"
RDEPENDS_${PN} = "kexec-klibc"

# The binary itself is not machine-specific
# but the EXTRA_OECONF overrides have this effect 
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit autotools

# You can create your own *-img.h by doing
# ./make-image-header.sh <file>.png HAND

SRC_URI += "file://logo-img.h \
        file://logo.png \
        "

export CC=${TARGET_PREFIX}klcc

# Defaults as in ver 0.5+0.6b
#############################
# Optional Features:
#  --disable-option-checking  ignore unrecognized --enable/--with options
#  --disable-FEATURE       do not include FEATURE (same as --enable-FEATURE=no)
#  --enable-FEATURE[=ARG]  include FEATURE [ARG=yes]
#  --enable-maintainer-mode  enable make rules and dependencies not useful
#                          (and sometimes confusing) to the casual installer
#  --enable-devices-recreating
#                          enable devices re-creating [default=yes]
#  --enable-debug          enable debug output [default=no]
#  --enable-host-debug     allow for non-destructive executing of kexecboot on
#                          host system[default=no]
#  --disable-dependency-tracking  speeds up one-time build
#  --enable-dependency-tracking   do not reject slow dependency extractors
#
# Optional Packages:
#  --with-PACKAGE[=ARG]    use PACKAGE [ARG=yes]
#  --without-PACKAGE       do not use PACKAGE (same as --with-PACKAGE=no)
#  --with-static-linking   compiles kexecboot as a static executable
#                          [default=no]
#  --with-fbmenu           support framebuffer menu [default=yes]
#  --with-cfgfiles         support config files [default=yes]
#  --with-icons            support custom icons (depends on fbmenu)
#                          [default=yes]
#  --with-zaurus           compile Sharp Zaurus specific code [default=no]
#  --with-zimage           compile with zImage support [default=yes]
#  --with-uimage           compile with uImage support [default=no]
#  --with-machine-kernel   enable looking for machine-specific zImage kernel
#                          [default=no]
############################

EXTRA_OECONF_akita = "--with-zaurus"
EXTRA_OECONF_c7x0 = "--with-zaurus"
EXTRA_OECONF_spitz = "--with-zaurus"
EXTRA_OECONF_poodle = "--with-zaurus"
EXTRA_OECONF_tosa = "--with-zaurus"

EXTRA_OECONF_omap3 = "--with-uimage"

do_configure_prepend () {
        install -m 0644 ${WORKDIR}/logo-img.h ${S}/res/
        install -m 0644 ${WORKDIR}/logo.png ${S}/res/
}

do_install () {
        install -d ${D}${bindir}
        install -m 0755 kexecboot ${D}${bindir}/

        install -d ${D}/proc
        install -d ${D}/mnt
}

FILES_${PN} += " ${bindir}/kexecboot /init /proc /mnt"

pkg_postinst_${PN} () {
        ln -sf ${bindir}/kexecboot $D/init
}
