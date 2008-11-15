DESCRIPTION = "Opencv : The Open Computer Vision Library"
HOMEPAGE = "http://sourceforge.net/projects/opencvlibrary"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPLv2"

PR = "r0"

DEPENDS = "opencv"

SRC_URI = "cvs://anonymous@opencvlibrary.cvs.sourceforge.net/cvsroot/opencvlibrary;module=opencv \
"
SRCDATE = "20081115"
PV = "1.0.0+cvs${SRCDATE}"

S = "${WORKDIR}/opencv"

do_compile() {
    cd samples/c
	install -d ${D}/${bindir}

    for i in *.c; do
        echo "compiling $i"
        ${CXX} -ggdb `pkg-config --cflags opencv` -o `basename $i .c` $i `pkg-config --libs opencv`;
		install -m 0755 `basename $i .c` ${D}/${bindir}
	done
    for i in *.cpp; do
        echo "compiling $i"
        ${CXX} -ggdb `pkg-config --cflags opencv` -o `basename $i .cpp` $i `pkg-config --libs opencv`;
		install -m 0755 `basename $i .cpp` ${D}/${bindir}    
	done
}

