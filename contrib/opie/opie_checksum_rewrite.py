#!/usr/bin/env python
# ex:ts=4:sw=4:sts=4:et

# Opie recipe checksum rewriter
#
# A crude script for rewriting recipes to contain checksum information
#
# Some portions copied from oe-source-checker.py, copyright (C) 2007 OpenedHand

import os
import sys

def rewrite(recpfilename, sourcedir):
	insrc = False
	srcfirst = False
	sums = ''
	appname = ''
	output = ''
	f = open(recpfilename, 'r')
	for line in f:
		if line.startswith('require '):
			pn = os.path.basename(recpfilename)
			pn = pn[0:pn.find("_")]
			incfilename = line[8:].strip().replace("${PN}", pn)
			f2 = open(os.path.join(os.path.dirname(recpfilename), incfilename))
			for line2 in f2:
				if line2.startswith('APPNAME '):
					appname = line2[line2.find('"'):].strip('\n\r"')
			f2.close()
			output = output + line
			continue
		
		if line.startswith('SRC_URI['):
			continue

		if line.startswith('APPNAME '):
			appname = line[line.find('"'):].strip('\n\r"')
			output = output + line
			continue

		if not insrc and line.startswith('SRC_URI '):
			insrc = True
			srcfirst = True
			
		if insrc:
			pos = line.find('-split_')
			pos2 = line.find('.tar.bz2')
			if pos > -1 and pos2 > -1:
				name = line[pos+1:pos2]
				name = name.replace('${APPNAME}', 'appname')
				output = output + line.replace('.tar.bz2', '.tar.bz2;name=%s' % name)
				filename = line.strip('\n\r\t "\\').replace('${APPNAME}', appname)
				if srcfirst:
					filename = filename[filename.find('"')+1:]
				filename = filename.replace('http://sources.openembedded.org/', '')
				localpath = os.path.join(sourcedir, filename)
				if not os.path.isfile(localpath):
					raise IOError("file %s not found" % localpath)
				
				md5pipe = os.popen('md5sum ' + localpath)
				md5data = (md5pipe.readline().split() or [ "" ])[0]
				md5pipe.close()

				shapipe = os.popen('sha256sum ' + localpath)
				shadata = (shapipe.readline().split() or [ "" ])[0]
				shapipe.close()
				
				sums = sums + 'SRC_URI[%s.md5sum] = "%s"\n' % (name, md5data)
				sums = sums + 'SRC_URI[%s.sha256sum] = "%s"\n' % (name, shadata)
				
			else:
				output = output + line

			if (srcfirst and line.count('"') > 1) or (not srcfirst and line.find('"') > -1):
				insrc = False
				if sums:
					output = output + sums
			
			srcfirst = False
		else:
			output = output + line

	f.close()
	
	f = open(recpfilename, 'w')
	f.write(output)
	f.close()



if len(sys.argv) < 3:
    print """syntax: %s recipe dl_dir
  recipe - recipe.bb file
  dl_dir - location of local source files""" % sys.argv[0]
    sys.exit(1)

recipe = sys.argv[1]
dl_dir = sys.argv[2]

if not os.path.isfile(recipe):
    print >> sys.stderr, "%s: recipe file %s not found" % recipe
	sys.exit(1)

if not os.path.isdir(dl_dir):
    print >> sys.stderr, "%s: source dir %s not found" % dl_dir
	sys.exit(1)

rewrite(recipe, dl_dir)
