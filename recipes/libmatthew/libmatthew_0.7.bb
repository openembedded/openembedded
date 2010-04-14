require libmatthew.inc

PR = "r1"

SRC_URI = "http://www.matthew.ath.cx/projects/java/libmatthew-java-${PV}.tar.gz \
           file://Makefile-0.7.patch;patch=1"

SRC_URI[md5sum] = "da052ee0f71b66e52c175c1f6626c596"
SRC_URI[sha256sum] = "aaec468db4302bc7698c4168a261f8ea4dfdfd2bc69ff743c056c55cd6308a12"

VER_UNIX        ?= "0.4"

