# Makefile for OpenSlug
# Licensed under the GPL v2 or later

openslug-firmware: setup-env conf/local.conf
	. setup-env ; bitbake openslug-packages

# This does the same thing but with a clean environment
# The HOME setting prevents user environment settings
# from changing the build.  CCACHE_DIR is necessary to
# prevent ccache (if installed) attempting to use a
# .cache in the home directory.
openslug-firmware-safe: setup-env conf/local.conf
	env -i CCACHE_DISABLE=1 CCACHE_DIR="`pwd`/tmp/ccache" HOME=/dev/null \
		sh -c '. setup-env; bitbake openslug-packages'

setup-env:
	[ -e bitbake ]      || ln -s ../bitbake .
	[ -e downloads ]    || ln -s ../downloads .
	[ -e openembedded ] || ln -s ../openembedded .
	echo 'OEROOT='`pwd` > setup-env
	echo 'OESYS=$$OEROOT/bitbake/' >> setup-env
	echo 'OEBUILD=$$OEROOT' >> setup-env
	echo 'PKGDIR=$$OEROOT/openembedded/' >> setup-env
	echo 'export PYTHONPATH=$$OESYS/lib' >>setup-env
	echo 'export BBPATH=$$OEBUILD:$$PKGDIR:$$OESYS' >> setup-env
	echo 'export PATH=$$OESYS/bin/:$$PATH' >> setup-env
	echo 'export LD_LIBRARY_PATH=' >> setup-env
	echo 'export LANG=C' >> setup-env
	echo 'unset LC_CTYPE' >> setup-env
	echo 'unset CC' >> setup-env
	echo 'unset CXX' >> setup-env
	echo 'unset MFLAGS' >> setup-env
	echo 'unset MAKEFLAGS' >> setup-env
	echo 'alias bb=bitbake' >> setup-env
	echo 'echo Environment set up for OpenSlug development.' >> setup-env

conf/local.conf:
	sed -e "s|%%%OEROOT%%%|`pwd`|" conf/local.conf.template > conf/local.conf

clobber:
	rm -rf tmp

openslug-source:
	tar zcf openslug-source.tar.gz --exclude=MT Makefile bitbake conf openembedded

distclean: clobber
	rm -rf setup-env conf/local.conf bitbake downloads openembedded

# End of Makefile
