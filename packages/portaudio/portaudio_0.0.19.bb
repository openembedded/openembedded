DESCRIPTION = "A portable audio library"
SECTION = "libs"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
PV = "v19-cvs-${CVSDATE}"
PR = "r1"

SRC_URI = "http://www.portaudio.com/archives/pa_snapshot_v19.tar.gz"
S = "${WORKDIR}/portaudio"

inherit qmake

TESTS = "  pa_devs patest1      patest_hang patest_many                   patest_prime patest_sine patest_stop     patest_write_sine        \
pa_fuzz    patest_buffer        patest_in_overflow  patest_maxsines       patest_read_record  patest_sine8         patest_sync              \
pa_minlat  patest_callbackstop  patest_latency      patest_multi_sine     patest_record       patest_sine_formats  patest_toomanysines      \
paqa_devs  patest_clip          patest_leftright    patest_out_underflow  patest_ringmix      patest_sine_time     patest_underflow         \
paqa_errs  patest_dither        patest_longsine     patest_pink           patest_saw          patest_start_stop    patest_wire"

do_configure_prepend() {
    echo "TEMPLATE = subdirs" >portaudio.pro
    echo "SUBDIRS = lib tests" >>portaudio.pro

    mkdir -p lib
    cat <<EOF >lib/lib.pro    
TEMPLATE = lib
CONFIG = console debug warn_on
TARGET = portaudio
VERSION = 0.0.19
DESTDIR = .
DEFINES = PA_USE_OSS=1 HAVE_LIBPTHREAD=1
DEFINES += PA_LITTLE_ENDIAN

INCLUDEPATH = ../pa_common

SOURCES = \
        ../pa_common/pa_allocation.c \
        ../pa_common/pa_converters.c \
        ../pa_common/pa_cpuload.c \
        ../pa_common/pa_dither.c \
        ../pa_common/pa_front.c \
        ../pa_common/pa_process.c \
        ../pa_common/pa_skeleton.c \
        ../pa_common/pa_stream.c \
        ../pa_common/pa_trace.c \
\
        ../pa_unix_oss/pa_unix_oss.c \
        ../pa_unix/pa_unix_hostapis.c \
        ../pa_unix/pa_unix_util.c
EOF

    mkdir -p tests
    echo "TEMPLATE = subdirs" >tests/tests.pro
    echo "SUBDIRS = \\" >>tests/tests.pro
    
    for test in ${TESTS}
    do
        mkdir -p tests/$test
        cat <<EOF >tests/$test/$test.pro
TEMPLATE = app
CONFIG = console debug warn_on thread
DESTDIR = ../../bin
INCLUDEPATH = ../../pa_common/
LIBS = -L../../lib -lportaudio -lm
SOURCES = ../../pa_tests/$test.c
EOF
        echo "$test \\" >>tests/tests.pro
    done
    echo >>tests/tests.pro
}

do_stage() {
	oe_libinstall -so -C lib libportaudio ${STAGING_LIBDIR}
        install -m 0644 pa_common/portaudio.h ${STAGING_INCDIR}/portaudio.h
}

do_install() {
	install -d ${D}${libdir}
	install -d ${D}${bindir}
	install -d ${D}${includedir}
	oe_libinstall -so -C lib libportaudio ${D}${libdir}
	install -m 0644 pa_common/portaudio.h ${D}${includedir}
	install -m 0755 bin/* ${D}${bindir}/
}

PACKAGES = "libportaudio0 portaudio-dev portaudio-examples"
FILES_libportaudio0 = "${libdir}"
FILES_portaudio-examples = "${bindir}"
