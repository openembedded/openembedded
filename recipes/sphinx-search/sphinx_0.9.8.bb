DESCRIPTION = "The Sphinx Fulltext Indexer"
HOMEPAGE = "http://www.sphinxsearch.com/"
LICENSE = "GPL"
PRIORITY = "optional"
DEPENDS = "expat"

SRC_URI = "\
  http://www.sphinxsearch.com/downloads/sphinx-${PV}.tar.gz;name=archive \
  http://snowball.tartarus.org/dist/libstemmer_c.tgz;name=stemmer \
"

inherit autotools

EXTRA_OECONF = "\
  --without-mysql \
  --with-libstemmer \
"

# miscompiles w/ O2
FULL_OPTIMIZATION_arm = "-O1"

inherit autotools

do_configure_prepend() {
	mv ${WORKDIR}/libstemmer_c/* libstemmer_c/
}

SRC_URI[archive.md5sum] = "347e547b79b733778d7553ede34e0aac"
SRC_URI[archive.sha256sum] = "86de861550fc7b119b3cbe63a34bad32ac771f44c930d229775ac124c83571d9"
SRC_URI[stemmer.md5sum] = "8358a9ddaaffeeca7cb00725770f7cdb"
SRC_URI[stemmer.sha256sum] = "f3e93a41ad76e91f08e3115fa5065df8b69fd3f2dbdd9e982ae890b892ac6477"
# CHECKSUMS.INI MISMATCH: I've got this instead:
#SRC_URI[stemmer.md5sum] = "55af11ab6f73fcfd33e8949bb3eafcef"
#SRC_URI[stemmer.sha256sum] = "b642b8921915128bd95c99d302d33701cba8b5afbda81b762c118cbadfb7670f"
