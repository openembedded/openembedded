#!/bin/sh
# MIT Licensed
# Initial version by Graeme 'XorA' Gregory, Further changes by Koen Kooi

# Run this from inside ${DEPLOY_DIR} e.g. tmp/deploy/glibc/

# Angstrom webserver
REMOTEM=http://www.angstrom-distribution.org

# Feed dir we want to upload to
REMOTED=feeds/unstable/ipk/$(basename $PWD)

# create upload dir
mkdir -p upload-queue || true

# Find and delete morgue dirs, we don't need them
echo "Deleting morgue directories"
find ipk/ -name "morgue" -exec rm -rf \{\} \;

# Copy symlink packages to an upload queue
echo "Symlink packages to upload queue"
find ipk/ -name "*.ipk" -exec ln -sf ${PWD}/\{\} upload-queue/ \;

# Find file already present on webserver
echo "Getting file list from server"
wget $REMOTEM/$REMOTED/unsorted/files-sorted -O files-remote
ls upload-queue/ | grep -v morgue > files-local

# Check for files already present on webserver
echo "Checking for duplicates"
cat files-remote files-local | sort | uniq -u >files-uniq
cat files-uniq files-local | sort | uniq -d > files-trans

rm -f upload-queue/bigbuck* 

# Clean out stale packages
if [ -d personal-feed ] ; then
	rm -rf personal-feed
fi

mkdir -p personal-feed

# Copy over non-duplicate files
echo "Starting rsync..."
rsync -vz --partial --copy-links --progress --files-from=files-trans upload-queue/ personal-feed/

echo "Generating index for your personal feed..."
( cd personal-feed ; PATH=$PATH:$(find ../../../staging/$(uname -m)* -name "ipkg-make-index" | sed s:/ipkg-make-index::g) ipkg-make-index -p Packages -m . >& /dev/null )


# Clean up temporary files
echo "Removing upload queue"
rm -rf files-remote files-local files-uniq files-trans upload-queue	

echo "Your personal feed is now ready at ${PWD}/personal-feed"
