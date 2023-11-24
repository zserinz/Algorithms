package array

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
class Stock {
    fun maxProfit1(prices: IntArray): Int {
        var maxProfit = 0 // 초기값
        var minPrice = prices[0]

        for (price in prices) {
            minPrice = minPrice.coerceAtMost(price) // 최소값 세팅
            maxProfit = maxProfit.coerceAtLeast(price - minPrice) // 차이값이 제일 큰 값으로 교체
        }
        return maxProfit
    }

    fun maxProfit2(prices: IntArray): Int {
        // min 함수를 앞부분부터 실행해 나간다.
        prices.foldIndexed<Int>(prices[0]) { i, min, n ->
            prices[i] = n - min
            if (n < min) n else min // 현재 가격이 최소 가격보다 낮다면 최소 가격을 현재 가격으로 교체
        } // 함수가 끝나면, 각 시점에서의 최대 이익을 나타내게 된다.
        return prices.max() ?: 0 // 그 중, 가장 큰 값을 반환한다.
    }
}
