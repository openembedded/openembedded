PR = "r1"

require phoneme-advanced.inc

BUILDREV = "b87"
SRCREV = "13783"

SRC_URI += "file://${BUILDREV}-makefile-fix.patch;patch=1;pnum=0"

FILES_${PN} += "\
	${COMMON_DIR}/bin/cvm \ 
	${COMMON_DIR}/lib/btclasses.zip \
	${COMMON_DIR}${COMMON_DIR}/lib/content-types.properties \
	${COMMON_DIR}/lib/libawtjpeg.so \
	${COMMON_DIR}/lib/libqtawt.so \
	${COMMON_DIR}/lib/personal.jar \
	${COMMON_DIR}/lib/security/java.security \
	${COMMON_DIR}/lib/security/java.policy \
	${COMMON_DIR}/lib/zi/Asia/Novosibirsk \
	${COMMON_DIR}/lib/zi/Asia/Calcutta \
	${COMMON_DIR}/lib/zi/ZoneInfoMappings \
	${COMMON_DIR}/lib/zi/GMT \
	${COMMON_DIR}/lib/zi/America/Los_Angeles \
	${COMMON_DIR}/democlasses.jar \
	${COMMON_DIR}/testclasses.zip \
	${COMMON_DIR}/legal/license.txt \
	${COMMON_DIR}/legal/thirdpartylicensereadme.txt \
	${COMMON_DIR}/legal/copyright.txt \
	"

DEPENDS += "uicmoc3-native qt-x11-free"

PME_PROFILE = "personal"

oe_phoneme_configbase() {
  pmo CVM_DEBUG false
  pmo CVM_JIT true

  pmo AWT_PEERSET qt
  pmo QTDIR "${STAGING_DIR_HOST}/qt3"
  pmo QT_TARGET_DIR "${STAGING_DIR_HOST}/qt3"
  pmo X11_LIB_DIR "${STAGING_LIBDIR}"
  pmo MOC "${STAGING_DIR_HOST}/qt3/bin/moc"
}
