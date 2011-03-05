###########################
# Configure options:
#
#  --enable-static-linking compile kexecboot as static executable [default=no]
#  --enable-fbui           support framebuffer menu [default=yes]
#  --enable-textui         support console text user interface [default=no]
#  --enable-cfgfiles       support config files [default=yes]
#  --enable-icons          support custom icons (depends on fbui) [default=yes]
#  --enable-zaurus         compile Sharp Zaurus specific code [default=no]
#  --enable-zimage         compile with zImage support [default=yes]
#  --enable-uimage         compile with uImage support [default=no]
#  --enable-machine-kernel look for machine-specific zImage kernel [default=no]
#  --enable-devices-recreating
#                          enable devices re-creating [default=yes]
#  --enable-debug          enable debug output [default=no]
#  --enable-host-debug     allow for non-destructive executing of kexecboot on
#                            host system [default=no]
#  --enable-bg-buffer      enable buffer for pre-drawed FB GUI background
#                            [default=no]
#  --enable-timeout        allow to boot 1st kernel after timeout in seconds
#                            [default=no]
#  --enable-delay          specify delay before device scanning, allowing
#                            initialization of old CF/SD cards [default=1]
#  --enable-bpp            enable support of specified bpp modes
#                            (all,32,24,18,16,4,2,1) [default=all]
#  --enable-evdev-rate     change evdev (keyboard/mouse) repeat rate
#                            in milliseconds e.g. "1000,250" [default=no]
#  --with-kexec-binary     look for kexec binary at path
#                            [default="/usr/sbin/kexec"]
##########################
LICENSE = "GPL"

inherit autotools

EXTRA_OECONF_akita = "--enable-zaurus --enable-delay=2 --enable-evdev-rate=1000,250"
EXTRA_OECONF_c7x0 = "--enable-zaurus --enable-delay=2 --enable-evdev-rate=1000,250"
EXTRA_OECONF_spitz = "--enable-zaurus --enable-delay=3 --enable-evdev-rate=1000,250"
EXTRA_OECONF_poodle = "--enable-zaurus --enable-delay=2 --enable-evdev-rate=1000,250"
EXTRA_OECONF_tosa = "--enable-zaurus --enable-delay=2 --enable-evdev-rate=1000,250"
EXTRA_OECONF_collie = "--enable-delay=2 --enable-evdev-rate=1000,250"
EXTRA_OECONF_ben-nanonote = "--enable-uimage"
EXTRA_OECONF_omap3 = "--enable-uimage"

do_install () {
        install -d ${D}${bindir}
        install -m 0755 kexecboot ${D}${bindir}/
        install -d ${D}/proc
        install -d ${D}/mnt
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES_${PN} += " ${bindir}/kexecboot /init /proc /mnt"

pkg_postinst_${PN} () {
        ln -sf ${bindir}/kexecboot $D/init
}
