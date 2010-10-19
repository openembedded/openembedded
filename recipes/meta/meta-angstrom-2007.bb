# Meta file to inform the autobuilder which packages to build for the feeds
# Any changes should be discussed first on the angstrom-distro-devel mailinglist

# Try to keep it alphabetically sorted please
 
inherit meta

RDEPENDS_${PN} = ""

# Basic tools
RDEPENDS_${PN} += " \
         task-proper-tools \
	 screen \
	 "

# Browsers know to work on all archs
RDEPENDS_${PN} += " \
         midori \
	 minimo \
	 webkit-gtklauncher \
         "

# Webservers
RDEPENDS_${PN} += " \
        apache2 \
        boa \
	cherokee \
	lighttpd \
	thttpd \
	"
