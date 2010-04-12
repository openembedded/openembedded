LICENSE = "nokia"

# This is proprietary software in Chinook, so we have to stay with the last released
# free version.
SRC_URI = "http://repository.maemo.org/pool/bora/free/source/${PN}_${PV}-10.tar.gz \
           file://configure-fix-version.patch;patch=1"

PR = "r1"

inherit autotools


SRC_URI[md5sum] = "99ceada8d73504b5147f0ad6fa4af20f"
SRC_URI[sha256sum] = "ebc670611d304d362fa082cf8773a8ac0c10fda455f29ba777fbdc830002ef68"
