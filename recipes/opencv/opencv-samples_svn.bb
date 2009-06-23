DESCRIPTION = "Opencv : The Open Computer Vision Library"
HOMEPAGE = "http://sourceforge.net/projects/opencvlibrary"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPLv2"

DEPENDS = "opencv"

SRC_URI = "svn://opencvlibrary.svn.sourceforge.net/svnroot/opencvlibrary/trunk;module=opencv;proto=https \
"

SRCREV = "1820"
PV = "1.0.0+svnr${SRCREV}"

S = "${WORKDIR}/opencv"

do_install() {
    cd samples/c
	install -d ${D}/${bindir}

    for i in *.c; do
        echo "compiling $i"
        ${CXX} ${CFLAGS} ${LDFLAGS} -ggdb `pkg-config --cflags opencv` -o `basename $i .c` $i `pkg-config --libs opencv` || true
		install -m 0755 `basename $i .c` ${D}/${bindir} || true
	done
    for i in *.cpp; do
        echo "compiling $i"
        ${CXX} ${CFLAGS} ${LDFLAGS} -ggdb `pkg-config --cflags opencv` -o `basename $i .cpp` $i `pkg-config --libs opencv` || true
		install -m 0755 `basename $i .cpp` ${D}/${bindir} || true
	done
}

FILES_${PN} += "${bindir}"
