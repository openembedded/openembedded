HOMEPAGE = "http://www.linuxtv.org"
LICENSE = "GPL"
S = "${WORKDIR}/linuxtv-dvb-apps-${PV}"

SRC_URI = "http://linuxtv.org/downloads/linuxtv-dvb-apps-${PV}.tar.bz2 \
           file://makefile.patch;patch=1"

PACKAGES += "evtest evtest-dbg \
             dvbapp-tests dvbapp-tests-dbg \
             dvbdate dvbdate-dbg \
             dvbtraffic dvbtraffic-dbg \
             dvbnet dvbnet-dbg \
             dvb-scan dvb-scan-dbg dvb-scan-data \
             dvb-azap dvb-azap-dbg \
             dvb-czap dvb-czap-dbg \
             dvb-szap dvb-szap-dbg \
             dvb-tzap dvb-tzap-dbg \
             dvb-femon dvb-femon-dbg \
             dvb-zap-data"


TARGET_CC_ARCH += "${LDFLAGS}"

FILES_${PN} = ""
FILES_${PN}-dbg = ""
FILES_${PN}-doc = ""

FILES_evtest = "${bindir}/evtest"
FILES_evtest-dbg = "${bindir}/.debug/evtest"

FILES_dvbapp-tests = "${bindir}/test_*"
FILES_dvbapp-tests-dbg = "${bindir}/.debug/test_*"

FILES_dvbdate = "${bindir}/dvbdate"
FILES_dvbdate-dbg = "${bindir}/.debug/dvbdate"

FILES_dvbtraffic = "${bindir}/dvbtraffic"
FILES_dvbtraffic-dbg = "${bindir}/.debug/dvbtraffic"

FILES_dvbnet = "${bindir}/dvbnet"
FILES_dvbnet-dbg = "${bindir}/.debug/dvbnet"

FILES_dvb-scan = "${bindir}/scan"
FILES_dvb-scan-dbg = "${bindir}/.debug/scan"
FILES_dvb-scan-data = "${docdir}/dvb-apps/scan"

FILES_dvb-azap = "${bindir}/azap"
FILES_dvb-azap-dbg = "${bindir}/.debug/azap"

FILES_dvb-czap = "${bindir}/czap"
FILES_dvb-czap-dbg = "${bindir}/.debug/czap"

FILES_dvb-szap = "${bindir}/szap"
FILES_dvb-szap-dbg = "${bindir}/.debug/szap"

FILES_dvb-tzap = "${bindir}/tzap"
FILES_dvb-tzap-dbg = "${bindir}/.debug/tzap"

FILES_dvb-femon = "${bindir}/femon"
FILES_dvb-femon-dbg = "${bindir}/.debug/femon"

FILES_dvb-zap-data = "${docdir}/dvb-apps/szap"



do_install() {
    install -d ${D}/${bindir}
    install -d ${D}/${docdir}/dvb-apps
    install -d ${D}/${docdir}/dvb-apps/scan
    install -d ${D}/${docdir}/dvb-apps/szap

    # Install tests
    install -m 0755 ${S}/test/setvoltage      ${D}${bindir}/test_setvoltage
    install -m 0755 ${S}/test/set22k          ${D}${bindir}/test_set22k
    install -m 0755 ${S}/test/video           ${D}${bindir}/test_video
    install -m 0755 ${S}/test/sendburst       ${D}${bindir}/test_sendburst
    install -m 0755 ${S}/test/diseqc          ${D}${bindir}/test_diseqc
    install -m 0755 ${S}/test/test_sections   ${D}${bindir}/
    install -m 0755 ${S}/test/test_av_play    ${D}${bindir}/
    install -m 0755 ${S}/test/test_stillimage ${D}${bindir}/
    install -m 0755 ${S}/test/test_dvr_play   ${D}${bindir}/
    install -m 0755 ${S}/test/test_tt         ${D}${bindir}/
    install -m 0755 ${S}/test/test_sec_ne     ${D}${bindir}/
    install -m 0755 ${S}/test/test_stc        ${D}${bindir}/
    install -m 0755 ${S}/test/test_av         ${D}${bindir}/
    install -m 0755 ${S}/test/test_vevent     ${D}${bindir}/
    install -m 0755 ${S}/test/test_pes        ${D}${bindir}/
    install -m 0755 ${S}/test/test_dvr        ${D}${bindir}/

    # Install the utils
    install -m 0755 ${S}/util/dvbtraffic/dvbtraffic  ${D}${bindir}/
    install -m 0755 ${S}/util/scan/scan              ${D}${bindir}/
    install -m 0755 ${S}/util/szap/tzap              ${D}${bindir}/
    install -m 0755 ${S}/util/szap/czap              ${D}${bindir}/
    install -m 0755 ${S}/util/szap/femon             ${D}${bindir}/
    install -m 0755 ${S}/util/szap/szap              ${D}${bindir}/
    install -m 0755 ${S}/util/szap/azap              ${D}${bindir}/
    install -m 0755 ${S}/util/av7110_loadkeys/evtest ${D}${bindir}/
    install -m 0755 ${S}/util/dvbnet/dvbnet          ${D}${bindir}/
    install -m 0755 ${S}/util/dvbdate/dvbdate        ${D}${bindir}/

    # Install data files
    cp -pPR ${S}/util/scan/dvb-c    ${D}/${docdir}/dvb-apps/scan/
    cp -pPR ${S}/util/scan/dvb-s    ${D}/${docdir}/dvb-apps/scan/
    cp -pPR ${S}/util/scan/dvb-t    ${D}/${docdir}/dvb-apps/scan/
    cp -pPR ${S}/util/scan/atsc     ${D}/${docdir}/dvb-apps/scan/
    cp -pPR ${S}/util/scan/README   ${D}/${docdir}/dvb-apps/scan/

    cp -pPR ${S}/util/szap/channels.conf-* ${D}/${docdir}/dvb-apps/szap/
    cp -pPR ${S}/util/szap/README   ${D}/${docdir}/dvb-apps/szap/
}
