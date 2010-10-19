DESCRIPTION = "Standard Gtk+ icon theme for the Openmoko distribution"
SECTION = "openmoko/base"
PV = "0.1+svnr${SRCPV}"
PR = "r1"

inherit openmoko-base autotools

SRC_URI = "${OPENMOKO_MIRROR}/src/target/${OPENMOKO_RELEASE}/artwork;module=icons;proto=http"
S = "${WORKDIR}/icons"

pkg_postinst_openmoko-icon-theme-standard () {
#!/bin/sh -e
if [ "x$D" != "x" ]; then
    exit 1
fi
gtk-update-icon-cache ${datadir}/icons/openmoko-standard/
}

PACKAGE_ARCH = "all"
