SECTION = "gpe"
PRIORITY = "optional"
DEPENDS = "gtk+ libxrandr libxsettings libxsettings-client libgpewidget libdisplaymigration libeventdb libgpepimc libtododb"
PV = "0.11+svn-${SRCDATE}"
PR = "r0"

inherit gpe

SRC_URI = "${GPE_SVN} \
           file://Makefile.dpkg_ipkg \
           file://Makefile.translation"

S = "${WORKDIR}/${PN}"


do_compile () {
        sed -i 's:CVSBUILD = yes:CVSBUILD = no:' Makefile
        mkdir -p build
        cp ${WORKDIR}/Makefile.* build/
        oe_runmake PREFIX=${prefix}
        oe_runmake all-desktop PREFIX=${prefix}
}

DEFAULT_PREFERENCE = "-1"
