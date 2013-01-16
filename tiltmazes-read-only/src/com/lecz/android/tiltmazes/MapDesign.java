/*
 * Copyright (c) 2009, Balazs Lecz <leczbalazs@gmail.com>
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimer.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice,
 *       this list of conditions and the following disclaimer in the documentation
 *       and/or other materials provided with the distribution.
 * 
 *     * Neither the name of Balazs Lecz nor the names of
 *       contributors may be used to endorse or promote products derived from this
 *       software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 */

package com.lecz.android.tiltmazes;

public class MapDesign {
	private String mName;
	private int mSizeX = 0;
	private int mSizeY = 0;
	private int[][] mWalls;
	private int[][] mGoals;
	private int mInitialPositionX;
	private int mInitialPositionY;
	private int mGoalCount = 0;

	public MapDesign(String name,
			int sizeX, int sizeY,
			int[][] walls,
			int[][] goals,
			int initialPositionX,
			int initialPositionY) {
		mName = name;
		mSizeX = sizeX;
		mSizeY = sizeY;
		mWalls = walls;
		mGoals = goals;
		mInitialPositionX = initialPositionX;
		mInitialPositionY = initialPositionY;
		for (int y = 0; y < mSizeY; y++) {
			for (int x = 0; x < mSizeX; x++) {
				mGoalCount = mGoalCount + mGoals[y][x];
			}
		}
	}
	
	public String getName() {
		return mName;
	}

	public int[][] getWalls() {
		return mWalls;
	}

	public int getWalls(int x, int y) {
		return mWalls[y][x];
	}

	public int[][] getGoals() {
		return mGoals;
	}
	
	public int getGoalCount() {
		return mGoalCount;
	}

	public int getSizeX() {
		return mSizeX;
	}

	public int getSizeY() {
		return mSizeY;
	}

	public int getInitialPositionX() {
		return mInitialPositionX;
	}

	public int getInitialPositionY() {
		return mInitialPositionY;
	}
}
