DESCRIPTION = "User Interface Generator and Meta Object Compiler (moc) for Qt(E) 2.x"
SECTION = "devel"
PRIORITY = "optional"
LICENSE = "GPL/QPL"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
PR = "r0"

SRC_URI = "ftp://ftp.trolltech.com/pub/qt/source/qt-embedded-${PV}-free.tar.gz \
           file://fix-makefile.patch;patch=1 \
           file://gcc3_4.patch;patch=1" \
           file://gcc4.patch;patch=1"
S = "${WORKDIR}/qt-${PV}"

inherit native qmake-base

export QTDIR = "${S}"
EXTRA_OEMAKE = 'SYSCONF_CXX="${CXX}" SYSCONF_LINK="${CXX}"'
CXXFLAGS += " -DQWS"

QT_CONFIG_FLAGS = "-depths 8,16 -no-qvfb -no-g++-exceptions -no-jpeg -no-mng \
                   -qt-zlib -qt-libpng -no-xft -no-xkb -no-vnc -no-sm \
                   -no-opengl -static -qconfig oe"

do_configure() {
    touch src/tools/qconfig-oe.h
    echo "#define QT_NO_FREETYPE" >> src/tools/qconfig-oe.h
    echo yes | ./configure ${QT_CONFIG_FLAGS} || die "Configuring qt failed"
}

do_compile() {
    oe_runmake symlinks   || die "Can't symlink include files"
    oe_runmake -C src/moc || die "Building moc failed"

    cp src/moc/moc bin/

    oe_runmake -C src                 || die "Building libqt.a failed"
    oe_runmake -C tools/designer/util || die "Building libqutil.a failed"
    oe_runmake -C tools/designer/uic  || die "Building uic failed"
    oe_runmake -C tools/qvfb          || die "Building qvfb failed"
    oe_runmake -C tools/makeqpf       || die "Building makeqpf failed"
}

do_stage() {
    install -m 0755 bin/moc ${STAGING_BINDIR}
    install -m 0755 bin/uic ${STAGING_BINDIR}
    install -m 0755 tools/makeqpf/makeqpf ${STAGING_BINDIR}
}
