DESCRIPTION = "Set the root password."
SUMMARY = "On installation you will be prompted to set a root password. With \
this password you can then log into the machine."
LICENSE = "GPL"
DEPENDS = "gtk+"
PKG_TAGS_${PN} = "group::programming alias::Root_Password"

SRC_URI = "svn://svn.openmoko.org/developers/zecke/;module=root-password;proto=http"
S = "${WORKDIR}/root-password"
PV = "1.0+svnr${SRCREV}"
PE = "1"
PR = "r1"

do_compile () {
    cd ${S}
    oe_runmake
}

do_install() {
    install -d ${D}/${sbindir}
    install -m 0755 ${S}/root-password ${D}/${sbindir}/${PN}
}

pkg_postinst_${PN} () {
    # assume we use display 0
    DISPLAY=:0 ${sbindir}/${PN}
}
