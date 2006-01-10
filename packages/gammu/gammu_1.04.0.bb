DESCRIPTION = "GNU All Mobile Managment Utilities"
SECTION = "console/network"
DEPENDS = "bluez-libs"
LICENSE = "GPL"
HOMEPAGE = "http://mwiacek.com/gsm/soft/gammu.html"
AUTHOR = "Marcin Wiacek <marcin@mwiacek.com>"
MAINTAINER = "Marcin Juszkiewicz <openembedded@hrw.one.pl>"

SRC_URI = "http://www.mwiacek.com/zips/gsm/gammu/stable/1_0x/gammu-${PV}.tar.gz "

EXTRA_OECONF = "--disable-mysql"

inherit autotools

do_compile () {
        oe_runmake shared
}

do_stage() {
        install -d ${STAGING_INCDIR}/gammu/misc  ${STAGING_INCDIR}/gammu/misc/coding \
                   ${STAGING_INCDIR}/gammu/phone ${STAGING_INCDIR}/gammu/phone/at \
                   ${STAGING_INCDIR}/gammu/phone/obex ${STAGING_INCDIR}/gammu/phone/nokia \
                   ${STAGING_INCDIR}/gammu/phone/nokia/dct3 ${STAGING_INCDIR}/gammu/phone/nokia/dct4 \
                   ${STAGING_INCDIR}/gammu/phone/symbian ${STAGING_INCDIR}/gammu/phone/alcatel \
                   ${STAGING_INCDIR}/gammu/service ${STAGING_INCDIR}/gammu/service/sms \
                   ${STAGING_INCDIR}/gammu/service/backup ${STAGING_INCDIR}/gammu/device \
                   ${STAGING_INCDIR}/gammu/device/irda ${STAGING_INCDIR}/gammu/device/bluetoth \
                   ${STAGING_INCDIR}/gammu/device/serial ${STAGING_INCDIR}/gammu/protocol \
                   ${STAGING_INCDIR}/gammu/protocol/at ${STAGING_INCDIR}/gammu/protocol/obex \
                   ${STAGING_INCDIR}/gammu/protocol/nokia ${STAGING_INCDIR}/gammu/protocol/symbian \
                   ${STAGING_INCDIR}/gammu/protocol/alcatel

        oe_libinstall -so -C common libGammu ${STAGING_LIBDIR}

        install -m 0644 common/*.h                      ${STAGING_INCDIR}/gammu/
        install -m 0644 common/misc/*.h                 ${STAGING_INCDIR}/gammu/misc 
        install -m 0644 common/misc/coding/*.h          ${STAGING_INCDIR}/gammu/misc/coding 
        install -m 0644 common/phone/*.h                ${STAGING_INCDIR}/gammu/phone 
        install -m 0644 common/phone/at/*.h             ${STAGING_INCDIR}/gammu/phone/at 
        install -m 0644 common/phone/obex/*.h           ${STAGING_INCDIR}/gammu/phone/obex 
        install -m 0644 common/phone/nokia/*.h          ${STAGING_INCDIR}/gammu/phone/nokia 
        install -m 0644 common/phone/nokia/dct3/*.h     ${STAGING_INCDIR}/gammu/phone/nokia/dct3 
        install -m 0644 common/phone/nokia/dct4/*.h     ${STAGING_INCDIR}/gammu/phone/nokia/dct4 
        install -m 0644 common/phone/symbian/*.h        ${STAGING_INCDIR}/gammu/phone/symbian 
        install -m 0644 common/phone/alcatel/*.h        ${STAGING_INCDIR}/gammu/phone/alcatel 
        install -m 0644 common/service/*.h              ${STAGING_INCDIR}/gammu/service 
        install -m 0644 common/service/sms/*.h          ${STAGING_INCDIR}/gammu/service/sms 
        install -m 0644 common/service/backup/*.h       ${STAGING_INCDIR}/gammu/service/backup 
        install -m 0644 common/device/*.h               ${STAGING_INCDIR}/gammu/device 
        install -m 0644 common/device/irda/*.h          ${STAGING_INCDIR}/gammu/device/irda 
        install -m 0644 common/device/bluetoth/*.h      ${STAGING_INCDIR}/gammu/device/bluetoth 
        install -m 0644 common/device/serial/*.h        ${STAGING_INCDIR}/gammu/device/serial 
        install -m 0644 common/protocol/*.h             ${STAGING_INCDIR}/gammu/protocol 
        install -m 0644 common/protocol/at/*.h          ${STAGING_INCDIR}/gammu/protocol/at 
        install -m 0644 common/protocol/obex/*.h        ${STAGING_INCDIR}/gammu/protocol/obex 
        install -m 0644 common/protocol/nokia/*.h       ${STAGING_INCDIR}/gammu/protocol/nokia 
        install -m 0644 common/protocol/symbian/*.h     ${STAGING_INCDIR}/gammu/protocol/symbian 
        install -m 0644 common/protocol/alcatel/*.h     ${STAGING_INCDIR}/gammu/protocol/alcatel
}

do_install () {
        oe_runmake 'DESTDIR=${D}' installshared
}

PACKAGES =+ "libgammu"

FILES_${PN} = "${bindir}/gammu"
FILES_libgammu = "${libdir}/libGammu.so*"

PACKAGES_DYNAMIC = "gammu-locale-*"

python populate_packages_prepend () {
        help_dir = bb.data.expand('${datadir}/gammu/', d)
        
        do_split_packages(d, help_dir, file_regex='^gammu_(.*)\.txt$', output_pattern='gammu-locale-%s', description='%s translation for Gammu')
}
