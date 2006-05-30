DEFAULT_PREFERENCE = "-1"

DESCRIPTION = "Displays a summary of appointments and tasks for the day ahead"
DEPENDS = "gtk+ libxrandr libxsettings libxsettings-client libgpewidget libdisplaymigration libeventdb libgpepimc libtododb"
SECTION = "gpe"
PRIORITY = "optional"


S = "${WORKDIR}/${PN}"
#Remove the dash below when 0.10 changes in PV
PV = "0.11+cvs-${SRCDATE}"
PR = "r0"

inherit gpe

SRC_URI =		"${HANDHELDS_CVS};module=gpe/base/${PN} \
		 		 file://Makefile.dpkg_ipkg \
    		 	 file://Makefile.translation"


do_compile () {
	sed -i 's:CVSBUILD = yes:CVSBUILD = no:' Makefile
	mkdir build
	cp ${WORKDIR}/Makefile.* build/
	oe_runmake PREFIX=${prefix}
	oe_runmake all-desktop PREFIX=${prefix}
}


