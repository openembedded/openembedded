#
# Sanity check the users setup for common misconfigurations
#

inherit qemu

def raise_sanity_error(msg):
	import bb
	bb.fatal(""" Openembedded's config sanity checker detected a potential misconfiguration.
	Either fix the cause of this error or at your own risk disable the checker (see sanity.conf).
	Following is the list of potential problems / advisories:
	
	%s""" % msg)

def check_conf_exists(fn, data):
	bbpath = []
	fn = bb.data.expand(fn, data)
	vbbpath = bb.data.getVar("BBPATH", data)
	if vbbpath:
		bbpath += vbbpath.split(":")
	for p in bbpath:
		currname = os.path.join(bb.data.expand(p, data), fn)
		if os.access(currname, os.R_OK):
			return True
	return False

def check_sanity(e):
	from bb import note, error, data, __version__

	try:
		from distutils.version import LooseVersion
	except ImportError:
		def LooseVersion(v): print "WARNING: sanity.bbclass can't compare versions without python-distutils"; return 1
	import commands

	# Check the bitbake version meets minimum requirements
	minversion = data.getVar('BB_MIN_VERSION', e.data , True)
	if not minversion:
		# Hack: BB_MIN_VERSION hasn't been parsed yet so return 
		# and wait for the next call
		print "Foo %s" % minversion
		return

	if 0 == os.getuid():
		raise_sanity_error("Do not use Bitbake as root.")

	messages = ""

	if (LooseVersion(__version__) < LooseVersion(minversion)):
		messages = messages + 'Bitbake version %s is required and version %s was found\n' % (minversion, __version__)

	# Check TARGET_ARCH is set
	if data.getVar('TARGET_ARCH', e.data, True) == 'INVALID':
		messages = messages + 'Please set TARGET_ARCH directly, or choose a MACHINE or DISTRO that does so.\n'
	
	# Check TARGET_OS is set
	if data.getVar('TARGET_OS', e.data, True) == 'INVALID':
		messages = messages + 'Please set TARGET_OS directly, or choose a MACHINE or DISTRO that does so.\n'

	assume_provided = data.getVar('ASSUME_PROVIDED', e.data , True).split()
	# Check user doesn't have ASSUME_PROVIDED = instead of += in local.conf
	if "diffstat-native" not in assume_provided:
		messages = messages + 'Please use ASSUME_PROVIDED +=, not ASSUME_PROVIDED = in your local.conf\n'
	
	# Check that the MACHINE is valid, if it is set
	if data.getVar('MACHINE', e.data, True):
		if not check_conf_exists("conf/machine/${MACHINE}.conf", e.data):
			messages = messages + 'Please set a valid MACHINE in your local.conf\n'
	
	# Check that the DISTRO is valid
	# need to take into account DISTRO renaming DISTRO
	if not ( check_conf_exists("conf/distro/${DISTRO}.conf", e.data) or check_conf_exists("conf/distro/include/${DISTRO}.inc", e.data) ):
		messages = messages + "DISTRO '%s' not found. Please set a valid DISTRO in your local.conf\n" % data.getVar("DISTRO", e.data, True )

	missing = ""

	if not check_app_exists("${MAKE}", e.data):
		missing = missing + "GNU make,"

	if not check_app_exists('${BUILD_PREFIX}gcc', e.data):
		missing = missing + "C Compiler (${BUILD_PREFIX}gcc),"

	if not check_app_exists('${BUILD_PREFIX}g++', e.data):
		missing = missing + "C++ Compiler (${BUILD_PREFIX}g++),"

	required_utilities = "patch help2man diffstat texi2html makeinfo cvs svn bzip2 tar gzip gawk md5sum"

	# If we'll be running qemu, perform some sanity checks
	if data.getVar('ENABLE_BINARY_LOCALE_GENERATION', e.data, True):
		# Some versions of qemu-native needs gcc 3.x.  Do a special
		# check here to allow for host 'gcc' is 3.x.
		if "qemu-native" not in assume_provided and "gcc3-native" in assume_provided:
			gcc_version = commands.getoutput("${BUILD_PREFIX}gcc --version | head -n 1 | cut -f 3 -d ' '")

			if not check_gcc3(e.data) and gcc_version[0] != '3':
				messages = messages + "gcc3-native was in ASSUME_PROVIDED but the gcc-3.x binary can't be found in PATH"
				missing = missing + "gcc-3.x (needed for qemu-native),"

		if "qemu-native" in assume_provided:
			required_utilities += " %s" % (qemu_target_binary(e.data))

		try:
			if os.path.exists("/proc/sys/vm/mmap_min_addr"):
				f = file("/proc/sys/vm/mmap_min_addr", "r")
				if (f.read().strip() != "0"):
					messages = messages + "/proc/sys/vm/mmap_min_addr is not 0. This will cause problems with qemu so please fix the value (as root).\n\nTo fix this in later reboots, set vm.mmap_min_addr = 0 in /etc/sysctl.conf.\n"
				f.close()
		except:
			pass

	for util in required_utilities.split():
		if not check_app_exists( util, e.data ):
			missing = missing + "%s," % util

	if missing != "":
		missing = missing.rstrip(',')
		messages = messages + "Please install following missing utilities: %s\n" % missing

	try:
	    if os.path.basename(os.readlink('/bin/sh')) == 'dash':
		    messages = messages + "Using dash as /bin/sh causes various subtle build problems, please use bash instead.\n"
	except:
		pass

	omask = os.umask(022)
	if omask & 0755:
		messages = messages + "Please use a umask which allows a+rx and u+rwx\n"
	os.umask(omask)

	oes_bb_conf = data.getVar( 'OES_BITBAKE_CONF', e.data, True )
	if not oes_bb_conf:
		messages = messages + 'You do not include OpenEmbeddeds version of conf/bitbake.conf. This means your environment is misconfigured, in particular check BBPATH.\n'

	#
	# Check that TMPDIR hasn't changed location since the last time we were run
	#
	tmpdir = data.getVar('TMPDIR', e.data, True)
	checkfile = os.path.join(tmpdir, "saved_tmpdir")
	if os.path.exists(checkfile):
		f = file(checkfile, "r")
		oldpath = f.read().strip()
		if (oldpath != tmpdir):
			messages = messages + "Error, TMPDIR has changed location. You need to either move it back to %s or rebuild\n" % oldpath
	else:
		import bb
		bb.mkdirhier(tmpdir)
		f = file(checkfile, "w")
		f.write(tmpdir)
	f.close()

	#
	# Check the 'ABI' of TMPDIR
	#
	current_abi = data.getVar('OELAYOUT_ABI', e.data, True)
	abifile = data.getVar('SANITY_ABIFILE', e.data, True)
	if os.path.exists(abifile):
		f = file(abifile, "r")
		abi = f.read().strip()
		if not abi.isdigit():
			f = file(abifile, "w")
			f.write(current_abi)
		elif (abi != current_abi):
			# Code to convert from one ABI to another could go here if possible.
			messages = messages + "Error, TMPDIR has changed ABI (%s to %s) and you need to either rebuild, revert or adjust it at your own risk.\n" % (abi, current_abi)
	else:
		f = file(abifile, "w")
		f.write(current_abi)
	f.close()

	#
	# Check the Distro PR value didn't change
	#
	distro_pr = data.getVar('DISTRO_PR', e.data, True)
	prfile = data.getVar('SANITY_PRFILE', e.data, True)
	if os.path.exists(prfile):
		f = file(prfile, "r")
		pr = f.read().strip()
		if (pr != distro_pr):
			# Code to convert from one ABI to another could go here if possible.
			messages = messages + "Error, DISTRO_PR has changed (%s to %s) which means all packages need to rebuild. Please remove your TMPDIR so this can happen. For autobuilder setups you can avoid this by using a TMPDIR that include DISTRO_PR in the path.\n" % (pr, distro_pr)
	else:
		f = file(prfile, "w")
		f.write(distro_pr)
	f.close()


	#
	# Check there aren't duplicates in PACKAGE_ARCHS
	#
	archs = data.getVar('PACKAGE_ARCHS', e.data, True).split()
	for arch in archs:
		if archs.count(arch) != 1:
			messages = messages + "Error, Your PACKAGE_ARCHS field contains duplicates. Perhaps you set PACKAGE_EXTRA_ARCHS twice accidently through some tune file?\n"
			break

	if messages != "":
		raise_sanity_error(messages)

addhandler check_sanity_eventhandler
python check_sanity_eventhandler() {
    from bb.event import Handled, NotHandled
    if bb.event.getName(e) == "ConfigParsed":
        check_sanity(e)

    return NotHandled
}
