LICENSE = "GPL"
DESCRIPTION = "GNU Accounting Utilities - user and process accounting."

SRC_URI = "http://www.physik3.uni-rostock.de/tim/kernel/utils/acct/acct-6.4-pre1.tar.gz \
	file://cross-compile.patch;patch=1"

S = "${WORKDIR}/acct-6.4-pre1"

inherit autotools

SRC_URI[md5sum] = "9703f591801c5bbded35c9739d04f81c"
SRC_URI[sha256sum] = "68b1d0acd1a6e17d91412635cd4f65ba58d293e62a01475a43f3712c49a46e7d"
