DESCRIPTION = "Om Webbrowser using webkit."
SECTION = "openmoko/apps"
DEPENDS += "intltool libmokoui2 check webkit-gtk"
SRCREV = "4172"
PV = "0.0.1+svnr${SRCPV}"
PR = "r2"

inherit openmoko2
LDFLAGS_append = " -Wl,-rpath-link,${TOOLCHAIN_PATH}/${TARGET_SYS}/lib"

SRC_URI += "file://webkit-update.patch;minrev=3646;maxrev=4171"

#SRC_URI += "file://fingerscroll.diff"

do_compile_prepend() {
        find ${S} -name Makefile | xargs sed -i s:'-I/usr/include':"-I${STAGING_INCDIR}":g
}

