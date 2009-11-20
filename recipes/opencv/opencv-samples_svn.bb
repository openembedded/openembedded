DESCRIPTION = "Opencv : The Open Computer Vision Library"
HOMEPAGE = "http://sourceforge.net/projects/opencvlibrary"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPLv2"

DEPENDS = "opencv"

SRC_URI = "svn://opencvlibrary.svn.sourceforge.net/svnroot/opencvlibrary/trunk;module=opencv;proto=https \
"

SRCREV = "2219"
PV = "2.0.0+svnr${SRCPV}"

S = "${WORKDIR}/opencv"

do_install() {
    cd samples/c
	install -d ${D}/${bindir}
	install -d ${D}/${datadir}/opencv/samples

	cp * ${D}/${datadir}/opencv/samples || true

    for i in *.c; do
        echo "compiling $i"
        ${CXX} ${CFLAGS} ${LDFLAGS} -ggdb `pkg-config --cflags opencv` -o `basename $i .c` $i `pkg-config --libs opencv` || true
		install -m 0755 `basename $i .c` ${D}/${bindir} || true
		rm ${D}/${datadir}/opencv/samples/`basename $i .c` || true
	done
    for i in *.cpp; do
        echo "compiling $i"
        ${CXX} ${CFLAGS} ${LDFLAGS} -ggdb `pkg-config --cflags opencv` -o `basename $i .cpp` $i `pkg-config --libs opencv` || true
		install -m 0755 `basename $i .cpp` ${D}/${bindir} || true
		rm ${D}/${datadir}/opencv/samples/`basename $i .cpp` || true
	done
}

FILES_${PN}-dev += "${datadir}/opencv/samples/*.c* ${datadir}/opencv/samples/*.vcp* ${datadir}/opencv/samples/build*" 
FILES_${PN} += "${bindir} ${datadir}/opencv"
