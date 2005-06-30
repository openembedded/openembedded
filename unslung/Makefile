# Makefile for Unslung
# Licensed under the GPL v2 or later

unslung-firmware: setup-env conf/local.conf
	(source setup-env ; bitbake unslung-packages)

# This does the same thing but with a clean environment
# The HOME setting prevents user environment settings
# from changing the build.  CCACHE_DIR is necessary to
# prevent ccache (if installed) attempting to use a
# .cache in the home directory.
unslung-firmware-safe: setup-env conf/local.conf
	env -i CCACHE_DISABLE=1 CCACHE_DIR="`pwd`/tmp/ccache" HOME=/dev/null \
		sh -c 'source setup-env; bitbake unslung-packages'

setup-env:
	[ -e bitbake ]      || ( ln -s ../bitbake . )
	[ -e downloads ]    || ( ln -s ../downloads . )
	[ -e openembedded ] || ( ln -s ../openembedded . )
	[ -e oe-symlinks ]  || ( ln -s ../oe-symlinks . )
	echo 'OEROOT='`pwd` > setup-env
	echo 'OESYS=$$OEROOT/bitbake/' >> setup-env
	echo 'PKGDIR=$$OEROOT/openembedded/' >> setup-env
	echo 'OEBUILD=$$OEROOT' >> setup-env
	echo 'BBPATH=$$OEBUILD:$$PKGDIR:$$OESYS' >> setup-env
	echo 'PATH=$$OESYS/bin/:$$PATH' >> setup-env
	echo 'LD_LIBRARY_PATH=' >> setup-env
	echo 'export PATH LD_LIBRARY_PATH BBPATH' >> setup-env
	echo 'export LANG=C' >> setup-env
	echo 'unset LC_CTYPE' >> setup-env
	echo 'unset CC' >> setup-env
	echo 'unset CXX' >> setup-env
	echo 'alias bb=bitbake' >> setup-env
	echo 'echo Environment set up for Unslung development.' >> setup-env

conf/local.conf:
	sed -e "s|%%%OEROOT%%%|`pwd`|" conf/local.conf.template > conf/local.conf

clobber:
	rm -rf tmp

unslung-source:
	tar zcvf unslung-source.tar.gz --exclude=MT Makefile bitbake conf openembedded oe-symlinks

distclean: clobber
	rm -f setup-env conf/local.conf bitbake downloads openembedded oe-symlinks

# End of Makefile
