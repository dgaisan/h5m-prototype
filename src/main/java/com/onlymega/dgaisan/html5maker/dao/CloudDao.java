package com.onlymega.dgaisan.html5maker.dao;

import java.io.File;
import java.io.IOException;

import com.amazonaws.AmazonServiceException;

/**
 * DAO for saving files on S3.
 * It copies/saves/reads files in the could.
 * 
 * @author Dmitri Gaisan
 *
 */
public interface CloudDao {
	
	/**
	 * Saves a file on S3.
	 * 
	 * @param bucketName
	 * @param path representing folder in which file is stored
	 * @param filename name of the actual file
	 * @param inputFile binary input file
	 * @return ?? <TODO>
	 * @throws AmazonServiceException
	 * @throws IOException
	 * @throws Exception
	 */
	String save(String bucketName, String path, String filename, File inputFile) throws IOException;
	
	
}