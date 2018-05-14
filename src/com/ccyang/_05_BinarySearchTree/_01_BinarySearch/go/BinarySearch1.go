package main

/**
 	二分查找法，在有序数组 arr中查找target
 	如果找到target，则返回对应元素下标
	如果没找到target，则返回-1
 */
func binarySearch(arr []int, target int) int {

	// 在arr[l...r]之中查找target
	l := 0
	r := len(arr)
	for ; l <= r ;{
		num := (l+r)/2
		if( arr[num] == target ){
			return num
		}
		if(arr[num] < target){
			// 在 arr[num+1...r]中查找target
			l = num+1
		}else{
			// 在 arr[l...num-1]中查找target
			r = num - 1
		}
	}
	return -1
}

func main(){
	var arr = []int{1,2,3,4,5,7,9,22,33,44,55,66}
	num := binarySearch(arr,33)
	print(num)
}
