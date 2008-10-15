require rdiff-backup.inc
FILE_PR = "r0"

# 1.1.x added the use of sha which we get from python-crypt
RDEPENDS_${PN} += "python-crypt"
