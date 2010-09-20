DESCRIPTION = "iPhone development headers"
SECTION = "libs"
PROVIDES = "linux-libc-headers"

INHIBIT_DEFAULT_DEPS = "1"
COMPATIBLE_MACHINE = "(iphone)"
# note: see iphone-sources script to get/generate the tarballs
SRC_URI = "\
	file://iphone-sdks-${PV}.tar.bz2 \
	\
	file://cctools-667.8.0.tar.gz \
	file://CF-476.14.tar.gz \
	file://configd-210.tar.gz \
	file://DirectoryService-514.23.tar.gz \
	file://DiskArbitration-183.tar.gz \
	file://IOCDStorageFamily-39.tar.gz \
	file://IODVDStorageFamily-26.tar.gz \
	file://IOGraphics-193.2.tar.gz \
	file://IOHIDFamily-258.3.tar.gz \
	file://IOKitUser-388.2.1.tar.gz \
	file://IOStorageFamily-88.tar.gz \
	file://JavaScriptCore-466.1.tar.gz \
	file://launchd-258.1.tar.gz \
	file://Libc-498.tar.gz \
	file://libsecurity_authorization-32564.tar.gz \
	file://libsecurity_cdsa_client-32432.tar.gz \
	file://libsecurity_cdsa_utilities-33506.tar.gz \
	file://libsecurity_cms-32521.tar.gz \
	file://libsecurity_codesigning-33803.tar.gz \
	file://libsecurity_cssm-32993.tar.gz \
	file://libsecurityd-33470.tar.gz \
	file://libsecurity_keychain-34101.tar.gz \
	file://libsecurity_mds-32820.tar.gz \
	file://libsecurity_ssl-32463.tar.gz \
	file://libsecurity_utilities-32820.tar.gz \
	file://WebCore-351.9.tar.gz \
	file://xnu-1228.3.13.tar.gz \
	file://xnu-1228.7.58.tar.gz \
"
DARWIN_SOURCES_DIR = "${WORKDIR}"
IPHONE_SDK_INC = "${S}/iPhoneOS${PV}.sdk/usr/include"
IPHONE_SDK_LIBS = "${S}/iPhoneOS${PV}.sdk/System/Library/Frameworks"
LEOPARD_SDK_INC = "${S}/MacOSX10.5.sdk/usr/include"
LEOPARD_SDK_LIBS = "${S}/MacOSX10.5.sdk/System/Library/Frameworks"

do_compile() {
    find ${WORKDIR} ! -path "${S}/*" -print0 | xargs -0 chmod u+w 
}

# Follows the build routine for the toolchain described by saurik here:
# www.saurik.com/id/4
do_stage() {
	install -d ${STAGING_INCDIR}

	echo "Leopard"
	cd ${STAGING_INCDIR}
	rm -f System
	ln -sf . System
	cp -R -pf "${LEOPARD_SDK_INC}"/* ${STAGING_INCDIR}
	cp -R -pf "${IPHONE_SDK_INC}"/* ${STAGING_INCDIR}
	cp -R -pf "${DARWIN_SOURCES_DIR}"/xnu-1228.7.58/osfmk/* .
	cp -R -pf "${DARWIN_SOURCES_DIR}"/xnu-1228.7.58/bsd/* . 

	echo "mach"
	cp -R -pf "${DARWIN_SOURCES_DIR}"/cctools-*/include/mach .
	cp -R -pf "${DARWIN_SOURCES_DIR}"/cctools-*/include/mach-o .
	cp -R -pf "${IPHONE_SDK_INC}"/mach-o/dyld.h mach-o

	cp -R -pf "${LEOPARD_SDK_INC}"/mach/machine mach
	cp -R -pf "${LEOPARD_SDK_INC}"/mach/machine.h mach
	cp -R -pf "${LEOPARD_SDK_INC}"/machine .
	cp -R -pf "${IPHONE_SDK_INC}"/machine .

	cp -R -pf "${IPHONE_SDK_INC}"/sys/cdefs.h sys
	cp -R -pf "${LEOPARD_SDK_INC}"/sys/dtrace.h sys

	cp -R -pf "${LEOPARD_SDK_LIBS}"/Kernel.framework/Versions/A/Headers/machine/disklabel.h machine
	cp -R -pf "${DARWIN_SOURCES_DIR}"/configd-*/dnsinfo/dnsinfo.h .
	cp -R -p "${DARWIN_SOURCES_DIR}"/Libc-*/include/kvm.h .
	cp -R -p "${DARWIN_SOURCES_DIR}"/launchd-*/launchd/src/*.h .

	cp -R -p i386/disklabel.h arm
	cp -R -p mach/i386/machine_types.defs mach/arm

	mkdir -p Kernel
	echo "libsa"
	cp -R -p "${DARWIN_SOURCES_DIR}"/xnu-1228.3.13/libsa/libsa Kernel

	mkdir -p Security
	echo "libsecurity"
	cp -R -p "${DARWIN_SOURCES_DIR}"/libsecurity_authorization-*/lib/*.h Security
	cp -R -p "${DARWIN_SOURCES_DIR}"/libsecurity_cdsa_client-*/lib/*.h Security
	cp -R -p "${DARWIN_SOURCES_DIR}"/libsecurity_cdsa_utilities-*/lib/*.h Security
	cp -R -p "${DARWIN_SOURCES_DIR}"/libsecurity_cms-*/lib/*.h Security
	cp -R -p "${DARWIN_SOURCES_DIR}"/libsecurity_codesigning-*/lib/*.h Security
	cp -R -p "${DARWIN_SOURCES_DIR}"/libsecurity_cssm-*/lib/*.h Security
	cp -R -p "${DARWIN_SOURCES_DIR}"/libsecurity_keychain-*/lib/*.h Security
	cp -R -p "${DARWIN_SOURCES_DIR}"/libsecurity_mds-*/lib/*.h Security
	cp -R -p "${DARWIN_SOURCES_DIR}"/libsecurity_ssl-*/lib/*.h Security
	cp -R -p "${DARWIN_SOURCES_DIR}"/libsecurity_utilities-*/lib/*.h Security
	cp -R -p "${DARWIN_SOURCES_DIR}"/libsecurityd-*/lib/*.h Security

	mkdir -p DiskArbitration
	echo "DiskArbitration"
	cp -R -p "${DARWIN_SOURCES_DIR}"/DiskArbitration-*/DiskArbitration/*.h DiskArbitration

	echo "iokit"
	cp -R -p "${DARWIN_SOURCES_DIR}"/xnu-*/iokit/IOKit .
	cp -R -p "${DARWIN_SOURCES_DIR}"/IOKitUser-*/*.h IOKit

	cp -R -p "${DARWIN_SOURCES_DIR}"/IOGraphics-*/IOGraphicsFamily/IOKit/graphics IOKit
	cp -R -p "${DARWIN_SOURCES_DIR}"/IOHIDFamily-*/IOHIDSystem/IOKit/hidsystem IOKit

	for proj in kext ps pwr_mgt; do
		mkdir -p IOKit/"${proj}"
		cp -R -p "${DARWIN_SOURCES_DIR}"/IOKitUser-*/"${proj}".subproj/*.h IOKit/"${proj}"
	done
    
	ln -sf IOKit/kext/bootfiles.h .

	mkdir -p IOKit/storage
	cp -R -p "${DARWIN_SOURCES_DIR}"/IOStorageFamily-*/*.h IOKit/storage
	cp -R -p "${DARWIN_SOURCES_DIR}"/IOCDStorageFamily-*/*.h IOKit/storage
	cp -R -p "${DARWIN_SOURCES_DIR}"/IODVDStorageFamily-*/*.h IOKit/storage

	mkdir -p DirectoryService
	cp -R -p "${DARWIN_SOURCES_DIR}"/DirectoryService-*/APIFramework/*.h DirectoryService

	mkdir -p DirectoryServiceCore
	cp -R -p "${DARWIN_SOURCES_DIR}"/DirectoryService-*/CoreFramework/Private/*.h DirectoryServiceCore
	cp -R -p "${DARWIN_SOURCES_DIR}"/DirectoryService-*/CoreFramework/Public/*.h DirectoryServiceCore 

	mkdir -p SystemConfiguration
	echo "configd"
	cp -R -p "${DARWIN_SOURCES_DIR}"/configd-*/SystemConfiguration.fproj/*.h SystemConfiguration

	echo "CoreFoundation"
	mkdir -p CoreFoundation
	cp -R -p "${LEOPARD_SDK_LIBS}"/CoreFoundation.framework/Versions/A/Headers/* CoreFoundation
	cp -R -pf "${DARWIN_SOURCES_DIR}"/CF-*/*.h CoreFoundation
	cp -R -pf "${IPHONE_SDK_LIBS}"/CoreFoundation.framework/Headers/* CoreFoundation

	for framework in AudioToolbox AudioUnit CoreAudio QuartzCore Foundation; do
		echo $framework
		mkdir -p $framework
		cp -R -p "${LEOPARD_SDK_LIBS}"/"${framework}".framework/Versions/?/Headers/* "${framework}"
		cp -R -pf "${IPHONE_SDK_LIBS}"/"${framework}".framework/Headers/* "${framework}"
	done

	for framework in UIKit AddressBook CoreLocation; do
		echo $framework
		mkdir -p $framework
		cp -R -pf "${IPHONE_SDK_LIBS}"/"${framework}".framework/Headers/* "${framework}"
	done

	for framework in AppKit Cocoa CoreData CoreVideo JavaScriptCore OpenGL WebKit; do
		echo $framework
		mkdir -p $framework
		cp -R -p "${LEOPARD_SDK_LIBS}"/"${framework}".framework/Versions/?/Headers/* $framework
	done
	
	echo "Application Services"
	mkdir -p ApplicationServices
	cp -R -p "${LEOPARD_SDK_LIBS}"/ApplicationServices.framework/Versions/A/Headers/* ApplicationServices
	for service in "${LEOPARD_SDK_LIBS}"/ApplicationServices.framework/Versions/A/Frameworks/*.framework; do
		echo -e "\t$(basename $service .framework)"
		mkdir -p "$(basename $service .framework)"
		cp -R -p $service/Versions/A/Headers/* "$(basename $service .framework)"
	done

	echo "Core Services"
	mkdir -p CoreServices
	cp -R -p "${LEOPARD_SDK_LIBS}"/CoreServices.framework/Versions/A/Headers/* CoreServices
	for service in "${LEOPARD_SDK_LIBS}"/CoreServices.framework/Versions/A/Frameworks/*.framework; do
		mkdir -p "$(basename $service .framework)"
		cp -R -p $service/Versions/A/Headers/* "$(basename $service .framework)"
	done

	echo "WebCore"
	mkdir -p WebCore
	cp -R -p "${DARWIN_SOURCES_DIR}"/WebCore-*/bindings/objc/*.h WebCore
	cp -R -p "${DARWIN_SOURCES_DIR}"/WebCore-*/bridge/mac/*.h WebCore 
	for subdir in css dom editing history html loader page platform{,/{graphics,text}} rendering; do
	    cp -R -p "${DARWIN_SOURCES_DIR}"/WebCore-*/"${subdir}"/*.h WebCore
	done

	cp -R -p "${DARWIN_SOURCES_DIR}"/WebCore-*/css/CSSPropertyNames.in WebCore
	(cd WebCore; perl "${DARWIN_SOURCES_DIR}"/WebCore-*/css/makeprop.pl)

	mkdir -p kjs
	cp -R -p "${DARWIN_SOURCES_DIR}"/JavaScriptCore-*/kjs/*.h kjs

	mkdir -p wtf/unicode/icu
	cp -R -p "${DARWIN_SOURCES_DIR}"/JavaScriptCore-*/wtf/*.h wtf
	cp -R -p "${DARWIN_SOURCES_DIR}"/JavaScriptCore-*/wtf/unicode/*.h wtf/unicode
	cp -R -p "${DARWIN_SOURCES_DIR}"/JavaScriptCore-*/wtf/unicode/icu/*.h wtf/unicode/icu

	mkdir -p unicode
	cp -R -p "${DARWIN_SOURCES_DIR}"/JavaScriptCore-*/icu/unicode/*.h unicode
}

