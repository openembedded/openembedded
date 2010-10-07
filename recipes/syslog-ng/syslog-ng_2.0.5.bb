require syslog-ng.inc
PR = "${INC_PR}.0"

SRC_URI = "http://www.balabit.com/downloads/files/syslog-ng/sources/2.0/src/${P}.tar.gz \
          file://syslog-ng.conf \
          file://initscript"

SRC_URI[md5sum] = "c161eefc450fabc246c1a10997c6c6a5"
SRC_URI[sha256sum] = "34862f87d9d404ad4874d95ee871334f5bc2acad65420f672ad2ee286ab660a1"
