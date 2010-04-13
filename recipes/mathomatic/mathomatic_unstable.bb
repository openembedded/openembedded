require mathomatic.inc

SRC_URI = "http://www.panix.com/~gesslein/am.tgz"
S = "${WORKDIR}/mathomatic-12.4.2"

# source snapshot changes every day
BROKEN = "1"

SRC_URI[md5sum] = "df7535050d4bbe57c5d1243c8ec2479e"
SRC_URI[sha256sum] = "13ab5d2045d902b627725e7cf4fc82df3ec2e714e85e42b93bd48af7af9bffdc"
#CHECKSUMS.INI MISMATCH: I've got this instead:
#SRC_URI[md5sum] = "2bb4e37045da3ee21559f0f33c74e33f"
#SRC_URI[sha256sum] = "8f8f18f0cd76daffd6feee3ac14f679bda10b135f8a93032ebce334f0952e0e1"
