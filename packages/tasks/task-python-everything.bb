DESCRIPTION= "Everything Python"
HOMEPAGE = "http://www.vanille.de/projects/python.spy"
LICENSE = "MIT"
PR = "ml36"

RDEPENDS = "\
		python-ao 		\
		python-cheetah		\
		python-connexion	\
		python-constraint	\
		python-dbus			\
		python-dialog		\
		task-python-efl			\
		task-python-efl-examples		\
		python-fam			\
		python-fnorb		\
		python-formencode	\
		python-fpconst		\
		python-fugrep		\
		python-fuse			\
		python-fusil		\
		python-gammu		\
		python-gmpy		\
		python-gnosis		\
		python-gsmd			\
		python-gst		\
		python-hmm		\
		python-imaging		\
		python-imdbpy		\
		python-inotify		\
		python-irclib		\
		python-itools		\
		python-logilab-common		\
		python-libgmail		\
		python-lightmediascanner \
		python-lxml		\
		python-m2crypto \
		python-mad		\
		python-mako		\
		python-numarray		\
		python-numeric		\
		python-ogg		\
		python-opendir		\
		python-pexpect		\
		python-ptrace		\
		python-pyalsa		\
		python-pyalsaaudio	\
		python-pybluez		\
		python-pycairo		\
		python-pychecker	\
		python-pycodes		\
		python-pycurl		\
		python-pydirectfb	\
		python-pyephem		\
		python-pyfits		\
		python-pyflakes		\
		python-pygame		\
		python-pygobject	\
		python-pygoogle		\
		python-pygtk-1.2	\
		python-pygtk		\
		python-pyid3lib		\
		python-pyiw		\
		python-pylinda		\
		python-pylint		\
		python-pyqt			\
		python-pyraf		\
		python-pyreverse	\
		python-pyrex		\
		python-pyro		\
		python-pyserial		\
		python-pytester		\
		python-pyusb		\
		python-pyvisa		\
		python-pyweather	\
		python-pyxml		\
		python-pyxmlrpc		\
		python-pyyaml		\
		python-scapy		\
		python-scons		\
		python-setuptools	\
		python-simplejson	\
		python-sip		\
		python-sgmlop		\
		python-snmplib		\
		python-soappy		\
		python-sphinxsearch	\
		python-spydi		\
		python-spyro		\
		python-sqlalchemy	\
		python-sqlobject	\
		python-sword		\
		python-tlslite		\
		python-urwid		\
		python-vmaps		\
		python-vorbis		\
		python-webpy		\
		moin			\
		plone			\
		python-twisted			\
		zope"

BROKEN_PACKAGES = "\
		python-egenix-mx-base \
		python-mysqldb \
        python-pyqwt        \
"

#fixme add python-pycap once libdnet is in again
#fixme add python-pyx once kpathwhich-native is there
#fixme add packages dynamically
LICENSE = "MIT"
