PR = "r1"

require phoneme-advanced.inc

BUILDREV = "b87"
SRCREV = "13783"

SRC_URI += "file://${BUILDREV}-makefile-fix.patch;patch=1;pnum=0"

FILES_${PN} += "\
	${COMMON_DIR}/bin/cvm \ 
	${COMMON_DIR}/lib/btclasses.zip \
	${COMMON_DIR}/lib/content-types.properties \
	${COMMON_DIR}/lib/foundation.jar \
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

